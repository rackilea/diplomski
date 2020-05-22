// UseTheString.java (a pure Java class)
public class UseTheString {
    public static void main(String[] arg) {
        String s = "Hello world";
        System.out.println(s);
        System.out.println(s.substring(1));
        ModifyStringClass.messWithMetaClasses(s);
        System.out.println(s.substring(1));
    }
}