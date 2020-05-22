public class MyClass {

    public static int numb = 10;
}
public class MyTest {

    private static int default_numb = MyClass.numb;

    public static boolean isChanged() {
        return MyClass.numb != default_numb;
    }

    public static void main(String[] args) {
        System.out.println(isChanged() + " " + MyClass.numb);
        MyClass.numb = 20;
        System.out.println(isChanged() + " " + MyClass.numb);
        MyClass.numb = 10;
        System.out.println(isChanged() + " " + MyClass.numb);
    }

}