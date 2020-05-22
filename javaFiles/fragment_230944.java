import java.util.*;
import java.lang.*; 

class Main{

    public static void main (String[] args) throws java.lang.Exception{
        testIterable(getStringList());     
    }

    public static ArrayList<String> getStringList(){
        ArrayList<String> stringList = new ArrayList<String>();

        stringList.add("String one");
        stringList.add("String two");

        return stringList;       

    }

    public static void testIterable(Object...objects){
        for(Object object : objects){
            System.out.println("Object: "+ object.toString());
        }
    }
}