public interface SpecialEnum {

}

enum MyEnum implements SpecialEnum {

    I, Me, My, Mine;
}

enum NotSpecialEnum {

    Am, I, Special;
}

public class BaseClass<E extends Enum<E> & SpecialEnum> {

    private final E e;

    public BaseClass(E e) {
        this.e = e;
    }
}

class A extends BaseClass<MyEnum> {

    public A(MyEnum e) {
        super(e);
    }

}

// This is not allowed.
class B extends BaseClass<NotSpecialEnum> {

    public A(NotSpecialEnum e) {
        super(e);
    }

}