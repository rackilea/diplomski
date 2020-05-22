import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        int [] i = new int [7]; //  array starts with 0, so we can init our array with size 7 (0 to 6).
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // there are 2 times "5"
        arr.add(5); 
        arr.add(5);

        //add some null
        arr.add(null);

        // there is 1 times "3"
        arr.add(3);

        // there is 1 times "6"
        arr.add(6);

        //add some null
        arr.add(null);

        System.out.println("numbers in arr: " + arr);

        for (Integer integer : arr) {
            if (integer!= null)
                i[integer]++; 
        }

        for (int c = 0 ;c<i.length ; c++){
            System.out.println("there are/is " + c + " ->" + i[c] + " times");
        }
    }
}