public class Test {
    public static void main(String[] args) {
        final Gson gson = new GsonBuilder()
            .registerTypeAdapter(MyClass.class, new DoubleToInt())
            .create();
        String stringValue = "{contact: {name: \"John\", \"age\": 5, children: [{\"name\": \"Mary\"}]}}";

        MyClass newValue = gson.fromJson(stringValue, MyClass.class);
        System.out.println(newValue.toString());
    }

    private static class DoubleToInt implements JsonDeserializer<MyClass> {

        @Override
        public MyClass deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            // do my custom stuff here

            return new MyClass(json);
        }
    }
}

class MyClass {
    private JsonElement element;

    MyClass(JsonElement element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}