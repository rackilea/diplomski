import java.io.*;
public class Test {

   public static void main(String args[]) {

        double ave = 0;
        int[] a = {1, 9, 5, 0, 7};
        double tmp = 0;

        for (int i = 0; i < a.length; i++) {
            tmp += a[i];
        }
        ave += (tmp / a.length);
        System.out.println(ave);
   }
}