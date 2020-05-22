import javafx.collections.ArrayChangeListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        ArrayList<Integer> a= new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(53);
        a.add(52);
        a.add(33);
        a.add(12);
        a.add(44);
        a.add(66);
        int i = 0;
        int z = 2;
        //Count to group the middle number by checking its value with respect to mod 2
        int count = 0;
        for(i = 0; i < a.size(); i++)
        {

           if(i == 0 )
            {
                z = i+1;
                System.out.println(""+a.get(i)+" " + "" +z+"" );

            }
            if(i > 0 && i != (a.size() -1))
            {
                //Increament z if the count is even so that we print the group for two times
                if(count%2 == 0)
                {
                    z++;
                }

                System.out.println(""+a.get(i)+"" +" "+ ""+z+"" );
                count ++;
            }
            if(i == a.size() -1 )
            {
                z++;
                System.out.println(""+a.get(i)+"" +" "+ ""+z+"" );
            }
        }
    }
}