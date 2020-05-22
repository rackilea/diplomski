public enum AnotherEnum {
    A, B, C;
}

public enum YetAnotherEnum {
    X, Y, Z;
}

public interface MyInterface {
    public Enum<?>[] getGenericReferenceValues();
}

public enum MyEnum implements MyInterface {
    value1(AnotherEnum.class),
    value2(YetAnotherEnum.class);

    final Class<? extends Enum<?>> a;

    private MyEnum(Class<? extends Enum<?>> a) {
        this.a = a;
    }

    public Enum<?>[] getGenericReferenceValues() {
        return a.getEnumConstants();
    }
}