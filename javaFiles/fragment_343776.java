public class ClassIsANaming implements Naming {
    public void doSomething() {
        someMethodDefinedInTheInterface();
    }

    @Override
    public void someMethodDefinedInTheInterface() {
        //....
    }
 }