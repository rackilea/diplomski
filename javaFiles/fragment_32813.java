public class NumberFormatSample {

    private static void getNumbers(Scanner sc) {
        System.out.println("Enter any two integers between 0-9 : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a < 0 || a > 9 || b < 0 || b > 9)
            throw new NumberFormatException("One of the input numbers was not within the specified range!");
    }

    public static void main(String[] args) {
        try {
            getNumbers(new Scanner(System.in));
        }
        catch(NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
    }
}