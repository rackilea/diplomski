interface YourInterface {
    void doSomething();
}

public class YourClass {

    @Inject @Any Instance<YourInterface> anImplementation;

    public void yourMethod(String someInput) {
        Annotation qualifier = turnInputIntoQualifier(someInput);
        anImplementation.select(qualifier).get().doSomething();
    }

    private Annotation turnInputIntoQualifier(String input) {
        ...
    }

}