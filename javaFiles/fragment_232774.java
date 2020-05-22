import java.util.Collections;
import java.util.Comparator;

public class Hello {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

         list.add("a.b.e.h");
         list.add("a.b.c");
         list.add("a.b.e.f.h.g");
         list.add("a.b.d");
         list.add("a.b.e.f");


         Collections.sort(list, new Comparator<String>() {
                public int compare(String a, String b) {
                   return findDot(a) - findDot(b);
                }

                 private int findDot(String a ){
                     String [] result = a.split("\\.");
                     return result.length;
                 }

            });

         for (String s : list) {
             System.out.println(s);
         }

    }

}