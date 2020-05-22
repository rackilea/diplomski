class SomeClass {

    Object var1 = "Hello";
    Object var2 = "AAA";

}

public TestApplication() {

    SomeClass myObject = new SomeClass();
    myObject.var2 = "BBB";

    String modificationString = "{\"var1\":\"Goodbye\"}";

    Gson gson = new Gson();
    JsonObject original = gson.fromJson(gson.toJson(myObject), JsonObject.class);
    JsonObject modification = gson.fromJson(modificationString, JsonObject.class);


    mergeObjects(original, modification);
    myObject = gson.fromJson(original, SomeClass.class);

    System.out.println(myObject.var1); // Prints "Goodbye"

}

public static void main(String[] args) {
    new DummyFile();
}