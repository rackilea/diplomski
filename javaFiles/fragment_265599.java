import java.util.*;

public class PrintListFromHashMap {

    public static void main( String [] args ) {

        Map<String,List<String>> hashMap = new HashMap<String,List<String>>();

        hashMap.put( "list",       new ArrayList<String>(Arrays.asList("A","B","C")));

        System.out.println( hashMap.get("list") );

    }

}

$ javac PrintListFromHashMap.java 
$ java PrintListFromHashMap
[A, B, C]