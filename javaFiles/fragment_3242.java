package stackOverflow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) {
        int[][][] int3dArray = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
                { { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } },
                { { 19, 20, 21 }, { 22, 23, 24 }, { 25, 26, 27 }, { 28 }, { 29, 30 } } };
        String[][] string2dArray = { { "He, llo" }, { "Wo", "rld" } };
        String[] stringArray = { "Hello", "World" };
        Object[] objectArray = { "Hell", 0, "W", 0, "rld" };

        List<Object> mixList = new ArrayList<Object>();
        mixList.add("String");
        mixList.add(3);
        mixList.add(string2dArray);

        System.out.println(flatten(int3dArray));
        System.out.println(flatten(flatten(int3dArray)));
        System.out.println(flatten(3));
        System.out.println(flatten(stringArray));
        System.out.println(flatten(string2dArray));
        System.out.println(flatten(objectArray));
        System.out.println(flatten(mixList));
    }

    private static List<Object> flatten(Object object) {
        List<Object> l = new ArrayList<Object>();
        if (object.getClass().isArray()) {
            for (int i = 0; i < Array.getLength(object); i++) {
                l.addAll(flatten(Array.get(object, i)));
            }
        } else if (object instanceof List) {
            for (Object element : (List<?>) object) {
                l.addAll(flatten(element));
            }
        } else {
            l.add(object);
        }
        return l;
    }
}