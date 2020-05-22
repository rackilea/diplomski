public interface SomeAction {
    int doSomething(int arg);
}

public class ActionOne implements SomeAction {
    public ActionOne() {}

    @Override
    public int doSomething(int arg) {
        return arg * 10;
    }
}

public class ActionTwo implements SomeAction {

    private boolean someSpecificArgument;

    public ActionTwo(boolean someSpecificArgument) {
        this.someSpecificArgument = someSpecificArgument;
    }

    @Override
    public int doSomething(int arg) {
        if (someSpecificArgument) {
            return arg * 1000;
        } else {
            return arg * 10;
        }
    }
}