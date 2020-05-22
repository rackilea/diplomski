package stackOverflow;

import java.lang.reflect.Array;


public class Solution
{
    public static void main(String[] args) {
        int[][][] array = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } },
                { { 19, 20, 21 }, { 22, 23, 24 }, { 25, 26, 27 }, { 28 } } };
        flatten(array);
    }

    private static void flatten(Object object) {
        if (object.getClass().isArray()) {
            for (int i = 0; i < Array.getLength(object); i++) {
                flatten(Array.get(object, i));
            }
        } else {
            System.out.print(object + ",");
        }
    }
}