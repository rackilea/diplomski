public class Test {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new StringBuilder("foo").append(str).append("bar").append(str).toString();
        System.out.println(str2);
    }
}