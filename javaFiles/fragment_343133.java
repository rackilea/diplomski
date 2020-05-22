import java.lang.reflect.*;
import java.util.*;

public class Program {

    private static Object[] toSingleDimension(Object array) {
        ArrayList<Object> arrayList = new ArrayList<>();
        toSingleDimensionRecursive(arrayList, array);
        return arrayList.toArray();
    }

    private static void toSingleDimensionRecursive(ArrayList<Object> output, Object object) {
        if (object == null) {
            output.add(null);
        } else if (!object.getClass().isArray()) {
            output.add(object);
        } else {
            int length = Array.getLength(object);
            for (int i = 0; i < length; ++i) {
                Object value = Array.get(object, i);
                toSingleDimensionRecursive(output, value);
            }
        }
    }

    private static String findLongestString(Object[] array) {
        if (array == null) {
            return null;
        }
        String result = null;
        for (Object object : array) {
            if (object != null) {
                String text = object.toString();
                if (result == null) {
                    result = text;
                } else if (text != null && text.length() > result.length()) {
                    result = text;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Object[][] inputs = {new Object[]{"a", "ab", "abc"},
            new Object[]{"abc", "ab", "a"},
            new Object[]{"big", new Object[]{"ab", "a",}, "t"},
            new Object[]{"big", new Object[]{"ab", "a", new Object[]{"superbig", "a"}}, "tiny"},
            new Object[]{123, 23123123, "a"},
            new Object[]{null, new Object[]{}, "a"}};

//      Object[] data = toSingleDimension(inputs);
//      System.out.println(Arrays.asList(data));

        ArrayList<String> longestStrings = new ArrayList<>();
        for (Object input : inputs) {
            Object[] array = toSingleDimension(input);
            String longest = findLongestString(array);
            if (longest != null) {
                longestStrings.add(longest);
            }
        }
        System.out.println("Longest strings of arrays: " + longestStrings);
    }
}