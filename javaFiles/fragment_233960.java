import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseFile
    {            
        public static void main (String[] args)
        {
            Scanner scanner = null;
            ArrayList<String> store = new ArrayList<String>();
            try {
               scanner= new Scanner(new File("input.txt"));
                while (scanner.hasNext()) {
                    store.add(scanner.next());             
                }
            } catch (Exception e) {
                e.printStackTrace();            
            }
            finally{
                scanner.close();
            }

            for (String item : store) {
                System.out.println(item);
            }

        }
    }