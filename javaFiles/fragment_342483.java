public class Test {
    public static void main(String[] args) {
        String str = "a" + "b" + "c";
        String str2 = "foo" + str + "bar" + str;
        System.out.println(str2);
    }
}