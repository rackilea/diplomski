public enum Color {
    RED, GREEN, YELLOW, BLUE;
}


public class MyEnumTest<E extends Enum<E>> {
    private final Class<E> enumType;
    private final E value; 

    public Class<E> getEnumType() {
        return enumType;
    }

    public E getValue() {
        return value;
    }

    public MyEnumTest(Class<E> enumType, E value) {
        this.enumType = enumType;
        this.value = value;
    }

    public MyEnumTest(Class<E> enumType) {
        this(enumType, enumType.getEnumConstants()[0]);
    }

    public static void main(String... args) {
        // no initial value provided
        MyEnumTest<Color> myET = new MyEnumTest<Color>(Color.class);
        if (myET.getValue() == Color.RED) {
            System.out.println("It's probably an apple");
        }

        // providing an initial value
        myET = new MyEnumTest<Color>(Color.class, Color.YELLOW);
        if (myET.getValue() == Color.YELLOW) {
            System.out.println("It's probably a banana");
        }
    }
}