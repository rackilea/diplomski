public class NewMain {
    public static void main(String args[]) throws ParseException {
        Scanner s = new Scanner(System.in);
        char yes;
        do {
            System.out.println("Hi");
            yes = s.next().charAt(0);
        } while (yes == 'Y'); // if u enter 'Y' the it will continue

    }
}