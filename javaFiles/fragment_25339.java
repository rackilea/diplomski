import java.util.Scanner;                  
import java.util.ArrayList;

class ArraylistString
{
    public static void main(String args[])
    {
        ArrayList<String> Str = new ArrayList<String>();
        Str.add("Jim Bob");
        Str.add("Bobby Jones");
        Str.add("Rob Stiles");
        int largestString = Str.get(0).length();
        int index = 0;

        for(int i = 0; i < Str.size(); i++)
        {
            if(Str.get(i).length() > largestString)
            {
                largestString = Str.get(i).length();
                                index = i;
            }
        }
        System.out.println("Index " + index + " "+ Str.get(index) + " " + "is the largest and is size " + largestString);  

    }

}