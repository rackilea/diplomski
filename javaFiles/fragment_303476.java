public class Greetings {
    public static void main(String[] args) {
        System.out.println("Hello there, what is your name? ");
        Scanner input = new Scanner(System.in);
        String theInput = input.nextLine();
        System.out.println("Well then, welcome to Java" + theInput);
        if (input != null) {
            input.close();   // close the Scanner once finished with it
        }
    }
}