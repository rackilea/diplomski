public class CustomEnum<E extends Enum<E>> {

    private E[] constants;

    public CustomEnum(Class<E> enumClass) {
        constants = enumClass.getEnumConstants();
    }

}