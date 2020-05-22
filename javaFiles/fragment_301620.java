public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.equals("HELLO")) {
            System.out.println("Compile Error: " + str);
            System.exit(1);
        }
        // Do something else.
    }
}