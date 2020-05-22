import java.util.Scanner;
class X {
    public static void main (String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter size of array");
        int n= input.nextInt();
        int[] x= new int[n];
        System.out.println("Enter Array nums");
        for(int i=0;i<n;i++){
            x[i]= input.nextInt();
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+= x[i];
        }
        // to print the result, uncomment the line below
        //System.out.println(sum);
    }
}