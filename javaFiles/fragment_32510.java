public class HelloWorld{

public static  void calculationMethod(int n, int k) {
        if(n<2 || n/2 < k) {
            System.out.println("Impossible");
            return;
        }
        else {
            int i = (int)Math.ceil(n/2.0);
            int j = n;
            int start = i;
            boolean flag = true;
            while(i>=1 || j>start) {
                if(flag) {
                   System.out.print(i + " " );
                   i--;
                   flag = false;
                }
                else {
                    System.out.print(j + " " );
                    j--;
                    flag = true;
                }
            }
        }
    }


     public static void main(String []args){
        calculationMethod(7,3);
     }
}