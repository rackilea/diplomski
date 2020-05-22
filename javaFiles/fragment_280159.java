import java.util.Scanner;
class shoppingApp
{
    //normally this shouldn't be public
    public static String orangeSelected = "";

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Premium Oranges\n");
        orangeSelected = scan.nextLine();
    }
}

 class gettersAndSetters
{
    //setter
    public void setOrangeSelected(String str)
    {
        Main.orangeSelected = str;
    }
    //getter
    public String getOrangeSelected()
    {
        return Main.orangeSelected;
    }
}