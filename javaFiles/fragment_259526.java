public class Triangle
{
    public static void main (String[]args)

    {

        int x, y, z;
        String proceed="";
        do
        {
             Scanner input = new Scanner(System.in);
        System.out.println("Please enter the 3 sides of the triangle.");

        x = input.nextInt();
        y = input.nextInt();
        z = input.nextInt();
        boolean goAgain;
        String userInput;

        TriMethods triTest = new TriMethods(x, y, z);

        System.out.println("You entered a triangle with the sides " + triTest.toString() + ": ");

        triTest.isEqual();
        triTest.isIsos();
        triTest.isScal();
        input.nextLine();
        System.out.println("Would you like to go again? y/n");

        proceed = input.nextLine(); //THIS DOESN'T WORK

        }while (!proceed.equalsIgnoreCase("n"));
    }
}