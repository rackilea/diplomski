import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        ArrayList<ArrayList> mainList = new ArrayList<ArrayList>();

        Scanner scan = new Scanner(System.in);
        String input = "";

        // in this example, get user input to make a list with
        // you can easily change this to use .getpickuptime()
        // in this case, input would be replaced by the object.
        while (!(input = scan.nextLine()).equals("quit")) {
            // base case - if the list is empty make a new object.
            if (mainList.isEmpty()) {
                ArrayList<String> x = new ArrayList<String>();
                x.add(input);
                mainList.add(x);
            } else {
                boolean added = false;
                // check the lists to see if there's a matching value
                for (ArrayList x : mainList) {
                    // check each arraylists first object 
                    if (x.get(0).equals(input)) { 
                        x.add(input);

                        // change added to true
                        added = true;

                        // you've added the object so quit the for loop.
                        break;
                    }
                }
                // what if you went through all the lists and there was no matching list?
                if (!added) {
                    // make a new list.
                    ArrayList<String> x = new ArrayList<String>();
                    x.add(input);
                    mainList.add(x);
                }
            }
        }

        System.out.println(mainList.toString());

        scan.close();
    }
}