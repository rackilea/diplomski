public class Test {

    public static String replaceAll(String string) {
        return string.replaceAll("\\d+.*", "");
    }

    public static void main(String[] args) {
        System.out.println(replaceAll("Alian 12WE"));
        System.out.println(replaceAll("ANI1451"));
    }   
}