public class PersonDecoratorSerializer implements JsonSerializer<PersonDecorator> {

    @Override
    public JsonElement serialize(PersonDecorator src, Type typeOfSrc, JsonSerializationContext context) {
        return context.serialize(src.getOriginalPerson()); 
    }
}