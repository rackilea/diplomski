abstract class Base {
    public abstract void bar();
}
abstract class BaseWithFoo extends Base {
    public abstract void foo();
}
class OneOfFiftyWithFoo extends BaseWithFoo {
    @Override
    public void foo() {
        ... // Implementation
    }
}