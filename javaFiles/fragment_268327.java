import java.util.*;
import java.lang.*;

class Main
{
   public static void main (String[] args) throws java.lang.Exception
   {
        /* Putting all team-mates in a List*/

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        /* Printing out the random name */

        System.out.println("The Team members are :");
        for(int i = 0; i < 3; i++)
        {
            int randomIndex = new Random().nextInt(list.size());
            //Integer randomValue = valuesList.get(randomIndex);
            String randomValue = list.remove(randomIndex);
            //String randomKey = keyList.get(randomIndex);
            System.out.println(randomValue);
        }
    }
}