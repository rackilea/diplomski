import java.util.ArrayList;
import java.util.ListIterator;

public class Test {

    public static void main(String[] args) {

        int[] test1 = { 3, 2, 5, 11, 11, 11, 233, 22, 3, 3, 3, 5, 5, 5 };   // false
        int[] test2 = { 3, 3, 3, 8, 3, 11, 233, 22, 3, 3, 3, 5, 5, 5 };     // false
        int[] test3 = { 3, 2, 5, 8, 3, 11, 233, 22, 3, 3, 4, 3, 3, 3 };     // false
        int[] test4 = { 3, 2, 5, 8, 3, 11, 233, 22, 3, 3, 5, 5, 5 };        // true
        System.out.println(haveThree(test1));
        System.out.println(haveThree(test2));
        System.out.println(haveThree(test3));
        System.out.println(haveThree(test4));

    }

    public static boolean haveThree(int[] nums) {

        int totalNumberOfThrees = 0;
        int threeInSuccessionCount = 0;
        boolean result = false;

        // convert to ArrayList
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }

        // use ListIterator to compare next value with previous value
        ListIterator<Integer> iterator = arrayList.listIterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            Integer previous = iterator.previous();
            // counts total number of 3's
            if (next.intValue() == 3) {
                totalNumberOfThrees++;
            }
            // if next and previous values == 3 then increase count by 1
            if (next.intValue() == 3 && previous.intValue() == 3) {
                threeInSuccessionCount++;
            } 
            // if next and previous values != 3 then reset counter
            else {
                threeInSuccessionCount = 0;
            }
            // if there are three consecutive 3's set threeInSuccessionCount == 3 
            // and then break from loop 
            if (threeInSuccessionCount == 3) {
                break;
            }
            iterator.next();
        }

        if (threeInSuccessionCount != 3 && totalNumberOfThrees >= 3) {
            result = true;

        } else {
            result = false;
        }

        return result;
    }
}