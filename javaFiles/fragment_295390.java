public class MyThing extends Thing {
    private final int arg;
    public MyThing() {
        super(arg = SomeOtherClass.func());
        ...
    }
    ...
}