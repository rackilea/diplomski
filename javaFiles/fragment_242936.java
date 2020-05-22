import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;

class Main {
    public static int sumArray(Object array) {
            Class type = array.getClass();
            if (!type.isArray()) {
                    throw new IllegalArgumentException("array");
            }
            Class ct = type.getComponentType();
            int res = 0;
            int len = Array.getLength(array);
            if (ct.isArray()) {
                    for (int i = 0 ; i != len ; i++) {
                            res += sumArray(Array.get(array, i));
                    }
            } else {
                    for (int i = 0 ; i != len ; i++) {
                            res += Array.getInt(array, i);
                    }
            }
            return res;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
            int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
            int aa[][] = new int[][] {{1,2},{3,4},{5,6}};
            int aaa[][][] = new int[][][]{{{1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12}}};
            System.out.println(sumArray(a));
            System.out.println(sumArray(aa));
            System.out.println(sumArray(aaa));
    }
}