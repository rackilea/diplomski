class TestClass {
    @Inject
    ClassnameCollection collection; // Inject


    void doSth(classsuffix) throws Exception {

        Class collectionClass = ClassnameCollection.class;

        Field collectionField = collectionClass.getDeclaredField("classname" + suffix); // Get the declared field by String
        TestInterface dynamicObject = (TestInterface) collectionField.get(collection); // There you have the dynamic object with all the subclasses (for example Logger) initialized

        dynamicObject.doStuff();
    }
}