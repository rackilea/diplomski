public class MyInterfaceSerializer implements JsonSerializer<MyInterface> {

public JsonElement serialize(MyInterface src, Type typeOfSrc,
        JsonSerializationContext context) {

    return context.serialize(src.name());
}