import java.util.*;
import java.lang.*;
import java.io.*;

class FloatTest {

    private static boolean isTwoBillion(float f) {
        return f == 2_000_000_000;
    }

    public static void main (String[] args) {
        System.out.println(isTwoBillion(2_000_000_001));
    }

}