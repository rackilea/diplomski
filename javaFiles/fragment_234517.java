import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
        public static void main(String args[]) {

                List<String> myList = new ArrayList<String>();
                myList.add("January");
                myList.add("February");
                myList.add("March");
                myList.add("April");

                Iterator<String> it = myList.iterator();
                while(it.hasNext())
                {
                    String item = it.next();
                    System.out.println("Checking: " + item);
                    if("February".equals(item))
                    {
                        myList.remove(item);
                    }
                }

                for (String item : myList)
                {
                    System.out.println(item);
                }

        }
}