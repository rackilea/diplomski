import java.io.*;
import java.util.*;

class javaQueueTest {
    public static void main(args){
        System.out.println("Hello World!");
        long startTime = System.currentTimeMillis();
        int i;
        int N = 50000000;
        int[] a = new int[N];
        for (i = 0;i < N; i = i+1){
            a[i] = 0;
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}