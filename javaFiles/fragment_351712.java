public class TestClass {
    public int methodA() {
        ExternalDependency e = buildExternalDependency("xyz", 10);
        return e.callExternalFunction();
    }

    protected ExternalDependency buildExternalDependency(String name, int number) {
          return BuilerClass.builder().withName(name).withNumber(number).build();       
    }

}