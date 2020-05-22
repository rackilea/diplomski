package test;
import java.util.ArrayList;

public class ArrayListPractice {
   public static void main(String[] args){
        ArrayList arr = new ArrayList();
        arr.add(10);
        arr.add(20);
        // arr is now [10,20]
        ArrayList arr2 = new ArrayList();
        arr2.add(new ArrayList(arr));
        arr2.add(30);
        // arr2 is now [[10,20],30]
        System.out.println(((ArrayList)arr2.get(0)).get(0)); // Prints out [10]
   }
}