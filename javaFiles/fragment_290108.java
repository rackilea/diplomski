class LineCountTest
{
    private static final String test = "This is a\ntest string\n\n\n";
    private static final String test2 = "This is a\ntest string\n\n\n ";

    public static void main(String[] args) {
        System.out.println("Line count: " + countLines(test));
        System.out.println("Line count: " + countLines(test2));
    }

    private static int countLines(String s) {
        return (s + " ").split("\r?\n").length;
    }
}