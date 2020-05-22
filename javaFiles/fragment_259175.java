public class ClassB extends ClassA {
    private static final int some_const = 1;

    public ClassB(int some_int) {
        super(some_const, some_int);
        this.name = SomeEnum.ENUM_1;
    }

    public static void main(String[] args) {
        ClassB b = new ClassB(4);
        b.toString();
    }
}