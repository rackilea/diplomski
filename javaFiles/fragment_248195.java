class TestClass {
    @Inject
    ClassnameCollection collection; // Inject


    void doSth(classsuffix) throws Exception {

        dynamicObject = CDI.current().select(
            (Class<TestInterface>) Class.forName("org.test.Classname" + suffix)).get();

        dynamicObject.doStuff();
    }
}