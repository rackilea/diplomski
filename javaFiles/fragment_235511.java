import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ArraysToString {
    public static void main(String[] args) {
        int[] array = {10, 16, 181, 200, 410, 68, 31, 555, 161, 313};

        System.out.println(Arrays.toString(array));
        System.out.println(arrayToString1(array));
        System.out.println(arrayToString2(array));
        System.out.println(arrayToString3(array));
        System.out.println(arrayToString4(array));
        // [10, 16, 181, 200, 410, 68, 31, 555, 161, 313]
        // [10, 16, 181, 200, 410, 68, 31, 555, 161, 313]
        // [10, 16, 181, 200, 410, 68, 31, 555, 161, 313]
        // [10, 16, 181, 200, 410, 68, 31, 555, 161, 313]
        // [10, 16, 181, 200, 410, 68, 31, 555, 161, 313]
    }


    static String arrayToString1(int[] array) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i : array) {
            stringJoiner.add(Integer.toString(i));
        }
        return stringJoiner.toString();
    }

    static String arrayToString2(int[] array) {
        return Arrays.stream(array)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));

    }

    static String arrayToString3(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        String separator = "";
        for (int i : array) {
            sb.append(separator);
            sb.append(Integer.toString(i));
            separator = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    static String arrayToString4(int[] array) {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }
}