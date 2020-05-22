public static void main(final String... args) {
    // Build a command DTO-aware Gson instance
    final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(getAbstractCommandDtoTypeAdapterFactory())
            .create();
    // Build command registry
    final Map<Class<?>, Consumer<?>> commandRegistry = new LinkedHashMap<>();
    commandRegistry.put(HelloCommandDto.class, new HelloCommand());
    // Simulate and accept a request
    final AbstractCommandDto abstractCommandDto = gson.fromJson("{\"command\":\"hello\",\"name\":\"Welt\"}", AbstractCommandDto.class);
    // Resolve a command
    final Consumer<?> command = commandRegistry.get(abstractCommandDto.getClass());
    if ( command == null ) {
        throw new IllegalArgumentException("Cannot handle " + abstractCommandDto.command);
    }
    // Dispatch
    @SuppressWarnings("unchecked")
    final Consumer<AbstractCommandDto> castCommand = (Consumer<AbstractCommandDto>) command;
    castCommand.accept(abstractCommandDto);
    // Simulate a response
    System.out.println(gson.toJson(abstractCommandDto));
}

private static final class HelloCommand
        implements Consumer<HelloCommandDto> {

    @Override
    public void accept(final HelloCommandDto helloCommandDto) {
        System.out.println("Hallo " + helloCommandDto.name);
    }

}