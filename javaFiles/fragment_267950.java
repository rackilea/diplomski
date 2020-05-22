final class AbstractCommandDtoTypeAdapterFactory
        implements TypeAdapterFactory {

    // The factory handles no state and can be instantiated once    
    private static final TypeAdapterFactory abstractCommandDtoTypeAdapterFactory = new AbstractCommandDtoTypeAdapterFactory();

    // Type tokens are used to define type information and are perfect value types so they can be instantiated once as well
    private static final TypeToken<CommandProbingDto> abstractCommandProbingDtoTypeToken = new TypeToken<CommandProbingDto>() {
    };

    private static final TypeToken<HelloCommandDto> helloCommandDtoTypeToken = new TypeToken<HelloCommandDto>() {
    };

    private AbstractCommandDtoTypeAdapterFactory() {
    }

    static TypeAdapterFactory getAbstractCommandDtoTypeAdapterFactory() {
        return abstractCommandDtoTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // First, check if the incoming type is AbstractCommandDto
        if ( AbstractCommandDto.class.isAssignableFrom(typeToken.getRawType()) ) {
            // If yes, then build a special type adapter for the concrete type
            final TypeAdapter<AbstractCommandDto> abstractCommandDtoTypeAdapter = new AbstractCommandDtoTypeAdapter(
                    gson,
                    gson.getDelegateAdapter(this, abstractCommandProbingDtoTypeToken),
                    (commandName, jsonObject) -> deserialize(gson, commandName, jsonObject),
                    dto -> getTypeAdapter(gson, dto)
            );
            // Some cheating for javac...
            @SuppressWarnings("unchecked")
            final TypeAdapter<T> typeAdapter = (TypeAdapter<T>) abstractCommandDtoTypeAdapter;
            return typeAdapter;
        }
        // If it's something else, just let Gson pick up the next type adapter
        return null;
    }

    // Create an AbstractCommandDto instance out of a ready to use JsonObject (see the disadvantages about JSON trees below)
    private AbstractCommandDto deserialize(final Gson gson, final String commandName, final JsonObject jsonObject) {
        @SuppressWarnings("unchecked")
        final TypeToken<AbstractCommandDto> typeToken = (TypeToken<AbstractCommandDto>) resolve(commandName);
        final TypeAdapter<AbstractCommandDto> typeAdapter = gson.getDelegateAdapter(this, typeToken);
        return typeAdapter.fromJsonTree(jsonObject);
    }

    private TypeAdapter<AbstractCommandDto> getTypeAdapter(final Gson gson, final AbstractCommandDto dto) {
        @SuppressWarnings("unchecked")
        final Class<AbstractCommandDto> clazz = (Class<AbstractCommandDto>) dto.getClass();
        return gson.getDelegateAdapter(this, TypeToken.get(clazz));
    }

    // Or any other way to resolve the class. This is just for simplicity and can be even extract elsewhere from the type adapter factory class
    private static TypeToken<? extends AbstractCommandDto> resolve(final String commandName)
            throws IllegalArgumentException {
        switch ( commandName ) {
        case "hello":
            return helloCommandDtoTypeToken;
        default:
            throw new IllegalArgumentException("Cannot handle " + commandName);
        }
    }

    private static final class AbstractCommandDtoTypeAdapter
            extends TypeAdapter<AbstractCommandDto> {

        private final Gson gson;
        private final TypeAdapter<CommandProbingDto> probingTypeAdapter;
        private final BiFunction<? super String, ? super JsonObject, ? extends AbstractCommandDto> commandNameToCommand;
        private final Function<? super AbstractCommandDto, ? extends TypeAdapter<AbstractCommandDto>> commandToTypeAdapter;

        private AbstractCommandDtoTypeAdapter(
                final Gson gson,
                final TypeAdapter<CommandProbingDto> probingTypeAdapter,
                final BiFunction<? super String, ? super JsonObject, ? extends AbstractCommandDto> commandNameToCommand,
                final Function<? super AbstractCommandDto, ? extends TypeAdapter<AbstractCommandDto>> commandToTypeAdapter
        ) {
            this.gson = gson;
            this.probingTypeAdapter = probingTypeAdapter;
            this.commandNameToCommand = commandNameToCommand;
            this.commandToTypeAdapter = commandToTypeAdapter;
        }

        @Override
        public void write(final JsonWriter out, final AbstractCommandDto dto)
                throws IOException {
            // Just pick up a delegated type adapter factory and use it
            // Or just throw an UnsupportedOperationException if you're not going to serialize command arguments
            final TypeAdapter<AbstractCommandDto> typeAdapter = commandToTypeAdapter.apply(dto);
            typeAdapter.write(out, dto);
        }

        @Override
        public AbstractCommandDto read(final JsonReader in) {
            // Here you can two ways:
            // * Either "cache" the whole JSON tree into memory (JsonElement, etc,) and simplify the command peeking
            // * Or analyze the JSON token stream in a more efficient and sophisticated way
            final JsonObject jsonObject = gson.fromJson(in, JsonObject.class);
            final CommandProbingDto commandProbingDto = probingTypeAdapter.fromJsonTree(jsonObject);
            // Or just jsonObject.get("command") and even throw abstractCommandDto, AbstractCommandProbingDto and all of it gets away
            final String commandName = commandProbingDto.command;
            return commandNameToCommand.apply(commandName, jsonObject);
        }

    }

    // A synthetic class just to obtain the command field
    // Gson cannot instantiate abstract classes like what AbstractCommandDto is 
    private static final class CommandProbingDto
            extends AbstractCommandDto {
    }

}