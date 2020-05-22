public class Test {
    public static void main(String[] args) {
        String first = "first";
        String second = "second";
        String third = "third";
        String text = first + "\0" + second + "\0" + third;
        System.out.println(text.length()); // Prints 18
    }
}