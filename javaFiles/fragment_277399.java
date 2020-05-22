public class GenericClass<T extends Enum<T>> {

    Class<T> enumClass;

    public GenericClass(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    public void doSomething() {
        for (T element : enumClass.getEnumConstants()) {

        }
    }
}