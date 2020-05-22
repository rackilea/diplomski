import java.util.Arrays;

public class Test{
    public static void main(String[] args){


        int arr[] = new int[5];
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 2;

        arr[3] = 2;

        arr[4] = 3;


        Arrays.sort(arr);
        System.out.print("(" + arr[0]);
        for (int i=1; i<arr.length;i++) {
            if(arr[i] == arr[i-1]) {
                System.out.print(arr[i]);
            }
            else {
                System.out.print(")(" + arr[i]);
            }
        }

        System.out.print(")");
    }
}