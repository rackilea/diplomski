public class RomanNumeralsTest
{
    public static void main(String[] args)     
    {
        Scanner scan = new Scanner(System.in);
        RomanNumerals rn = new RomanNumerals();
        System.out.println("Welcome to integer to Roman numeral conversion program ");
        System.out.println("------------------------------------------------------ ");
        System.out.print("Please enter an integer in the range 1-3999 (both inclusive): ");
        int number= scan.nextInt();
        if (number<=1||number >3999)
        {
            System.out.println("Sorry, the number is outside the range. Good bye!");
            System.exit(0);
        }

        System.out.println(number + " in Roman numerals is " + rn.convertToRomanNumeral(number));
        System.out.println("Thanks for using my program. Good bye!");
        System.exit(0);
    }

}