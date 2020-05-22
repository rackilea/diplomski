public abstract class AbstractBase() {}

public class Concrete1 extends AbstractBase() {}

public class Concrete2 extends AbstractBase() {}

public class Factory() {
    enum BaseType {
        Type1,
        Type2
    };

    public static AbstractBase getObject(BaseType baseType) {
        if (baseType == Type1) {
            return new Concrete1();
        } else if (baseType == Type2) {
            return new Concrete2();
        }
        throw new IllegalArgumentException();
    }
}