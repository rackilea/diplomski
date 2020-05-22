import java.util.*;

class StaticTest {

    Object[] arr = new Object[] { 1, 2, 3 };

    static Object[] testMethod() {
        //return arr; // you do not have an instance
        //return new String[] { "abc", "def" }; // possible
        StaticTest o = new StaticTest();
        return o.arr;
    }

    public static void main (String[] args) throws java.lang.Exception {
        System.out.println( Arrays.asList( testMethod() ) );
    }

}