import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the size of array:");

            int n = Integer.parseInt(b.readLine());

            ArrayList<Integer> a = new ArrayList<>(n);

            System.out.println("Enter the elements");

           for (int i = 1; i <= n; i++) {
               int value = Integer.parseInt(b.readLine());
               a.add(value);
           }

            System.out.println(a);

        } catch (Exception e) {
            System.err.println("");
        }
    }
}