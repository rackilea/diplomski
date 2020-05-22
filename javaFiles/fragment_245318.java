import java.util.*;

public class MyClass {
    public static void main(String []args){

    Scanner scanner = new Scanner(System.in);
    int arCount = scanner.nextInt();

    int[] ar = new int[arCount];
    for(int i=0;i<arCount;i++){
        ar[i] = scanner.nextInt();;
    }
    System.out.println(Arrays.toString(ar));

    scanner.close();
 }
}