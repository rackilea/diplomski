public class SomeClass {

    private static Scanner console;

    public static void main(String[] args) throws Exception {

        console = new Scanner(System.in);

        (...)

        console.close();
    }
}