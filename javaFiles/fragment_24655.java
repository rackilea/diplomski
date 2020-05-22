import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;

public class IterablesPredicateExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,-3,4,-5,6,-7,-8);
        Predicate<Integer> isNegative = new Predicate<Integer>() {
            @Override public boolean apply(Integer n) {
                return n < 0;
            }
        };          
        // Get index of first negative number
        System.out.println(Iterables.indexOf(nums, isNegative));
        // 2

        // Find that number
        System.out.println(Iterables.find(nums, isNegative));
        // -3

        // Find all negative numbers
        System.out.println(Iterables.filter(nums, isNegative));
        // [-3, -5, -7, -8]

        // Are all numbers negative?
        System.out.println(Iterables.all(nums, isNegative));
        // false

        // Find all non-negative numbers
        System.out.println(Iterables.filter(nums, Predicates.not(isNegative)));
        // [1, 2, 4, 6]
    }
}