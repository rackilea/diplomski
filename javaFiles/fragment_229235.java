import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer[]> l = new ArrayList<Integer[]>();
        Scanner s = new Scanner(System.in);
        System.out.println("How many rows will you enter?");
        int numOfRows = s.nextInt();
        for (int i = 0; i < numOfRows; i++) {
            String[] arr = s.nextLine().split(" ");
            Integer[] arr2 = new Integer[arr.length];
            for (int j = 0; j < arr.length; j++) {
                arr2[j] = Integer.parseInt(arr[j]);
            }
            l.add(arr2);
        }
        s.close();
        //Do whatever you want with l
    }
}