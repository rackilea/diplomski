import java.io.*;
import java.util.*;
class B{
    public static void main(String aregs[]) throws FileNotFoundException {
         Scanner s = new Scanner(new File("A.txt") );

         ArrayList<Object> list = new ArrayList<Object>();
         while(s.hasNext()) { 
            list.add(s.next());
         }
         System.out.println(list);


    } 
}