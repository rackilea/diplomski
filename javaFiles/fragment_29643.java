public class Test {   
    public static void main(String[] args) throws Exception {
        String string = "some^string";
        string = string.replaceAll("\\^", "");
        System.out.println(string); // Prints somestring
    }
}