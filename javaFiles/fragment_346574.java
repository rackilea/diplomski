import java.util.*;
import java.io.*;

public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] input = reader.readLine().split(" ");
    int[] numbers = new int[input.length - 1];
    for(int i = 0; i < numbers.length; i++) {
        numbers[i] = Integer.parseInt(input[i+1]);
    }

    System.out.println("Array = "+Arrays.toString(numbers));

}