package CallBefore;

public class Example implements ExampleInterface {

    @Override
    public void function1() {
    System.out.println("function1() has been called");
    }

    @Override
    public void function2() {
    System.out.println("function2() has been called");
    }

    @Override
    public void otherFunction() {
    System.out.println("otherFunction() has been called");
    }

    @Override
    public void refresh() {
    System.out.println("refresh() has been called");
    }
}