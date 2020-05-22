import java.lang.reflect.*;

class Validator {
    public static void main(String args[]) throws Exception {
        int[] a = {};
        float[] b = {};
        Integer[] c = {};
        Float[] d = {};
        System.out.println(Validator.isEmpty(a));            // true
        System.out.println(Validator.isEmpty(b));            // true
        System.out.println(Validator.isEmpty(c));            // true
        System.out.println(Validator.isEmpty(d));            // true
        System.out.println(Validator.isEmpty(new float[3])); // false (just double-checking)
    }

    public static boolean isEmpty(Object input) {
        if (input == null) {
            return true;
        }
        if (input instanceof String) {
            if (((String) input).trim().length() == 0) {
                return true;
            }
        }
        if (input.getClass().isArray()) {
            return Array.getLength(input) == 0;
        }
        return false;
    }
}