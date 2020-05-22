public class Test {
    public static void main(String args[]) {
        String str = "abc <some <thing>> def < 0";
        while (!str.equals(str = str.replaceAll("<([^>]*)>", "$1")));
        System.out.println(str);
    }
}