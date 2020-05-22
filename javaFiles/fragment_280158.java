import java.util.Scanner;
class shoppingApp
{
    //since it's an instance field not local to the class it's declared here instead of main
    static String orangeSelected = "";

    public static void main(String[] args)
    {
        //orange  selected is an odd name for a scanner, just use scan or something similar
        Scanner scan = new Scanner(System.in); //note that you were missing a semicolon
        System.out.println("Premium Oranges\n"); //include a new line or a space before asking for input, for example with \n
        orangeSelected = scan.nextLine();
    }
    //setter
    public static void setOrangeSelected(String str)
    {
        orangeSelected = str;
    }
    //getter
    public static String getOrangeSelected()
    {
        return orangeSelected;
    }

    //Note that all methods and instance fields are static because the main method must be static if you don't understand this yet that's ok.
}