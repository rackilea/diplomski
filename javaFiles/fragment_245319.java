import java.util.*;

public class MyClass {
    public static void main(String []args){

    Scanner scanner = new Scanner(System.in);
    int arCount = scanner.nextInt(); // doesn't consume \n
    int[] ar = new int[arCount];
    scanner.nextLine(); //consumes \n on same line 
    String line = scanner.nextLine(); // line is the string containing array numbers
    System.out.println(line);
    String[] arItems = line.trim().split(" "); //trim the line first, just in case there are extra spaces somewhere in the input
    System.out.println(Arrays.toString(arItems));
    for (int i = 0; i < arCount; i++) {
        int arItem = Integer.parseInt(arItems[i].trim());
        ar[i] = arItem;
    }
    System.out.println(Arrays.toString(arItems));
 }
}