import java.util.Arrays;
import java.util.Scanner;
class Main
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t =scan.nextInt(); scan.nextLine();

        for(int i = 0;i<t;i++)
        {
            String[] input = scan.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);

            int[] arr= new int[N];
            for(int x=0;x<N;x++){
                arr[i] = scan.nextInt();
                scan.nextLine();
            }

            int res=  bs(N,C,arr);
            System.out.println("RES = " + res);
        }

    }

    public static int bs(int N,int C,int[] arr) {
        Arrays.sort(arr);
        int left = 0;int right = arr[N-1]-arr[0];int mid =  arr[N-1]-arr[0];
        int max= -1;
        while(left<right){
            int temp= checker(mid,arr);
            if(temp>=C){
                if(max<mid)
                    max=mid;
                left = mid+1;
                mid = (left+right)/2;  }
            else {
                right= mid;
                mid=(left+right)/2;
            }
        }
        return max;
    }

    public static int checker(int mid,int[] arr){
        int f=0;int cows=1;
        for(int i=0;i<arr.length-1;i++) {
            if((arr[i+1]-arr[f])>=mid) {
                f=i+1;
                cows++;
            }
        }
        return cows;
    }
}