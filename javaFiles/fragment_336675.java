import java.util.*;
public class ArrayGame {
    public static void main(String[] args) {
        String arr[][] = new String[3][6];
        arr[2][4] = "example";
        if (Arrays.asList(arr[2]).subList(3,6).contains("example"))
            System.out.println("yes");    
    }
}