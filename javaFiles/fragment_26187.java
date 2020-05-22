class GetValuesFromEnum<E extends Enum<E>> {
    private Class<E> clazz;

    public GetValuesFromEnum(Class<E> clazz) {
        assert clazz.isEnum();
        this.clazz = clazz;
    }

    public void printValues() {
        for (E value : EnumSet.allOf(clazz)) {
            System.out.println(value);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        new GetValuesFromEnum<>(MyEnum.class).printValues();
    }
}