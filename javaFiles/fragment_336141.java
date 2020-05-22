package juxhin; // YOU write this class

public class ThirdPartyFooBehavior implements FooBehavior {
    private final Foo foo;

    public FooThirdPartyFooBehavior(Foo theirObject) {
        this.foo = theirObject;
    }

    @Override
    public void doSomething() throws MyException {
        try {
            foo.doSomething();
        } catch (ThirdPartyException e) {
            throw new MyException(e);
        }
    }
}