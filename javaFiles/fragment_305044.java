import java.util.Scanner;
public class Exercise1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int even =0;
        for(int i=0;i<=n;i++) {
            if(even%3==0) {
                sum=sum+even;
            }
            even=even +2;
        }
        System.out.print(""+sum);
    }
}