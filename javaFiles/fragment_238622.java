public class NamePrinter
{
    //each name in a series of names
    public String[] names = {"Hello", "My", "Name", "Is", "Jose"};

    //the method for putting names in 
    public void printNames(String [] namesArray) 
    {
        //go through each String in the array and then print each
        for(int i = 0; i < namesArray.length; i++)
        {
            System.out.println(namesArray[i]);
        }
    }

    public static void main(String[] a){
        NamePrinter namePrinter = new NamePrinter();

        //print the names in this specific array
        namePrinter.printNames(namePrinter.names);
    }
}