public class TestCode {
    public static void main(String[] args){
        int n = 4;
        int x = 5;
        double count = x;
        System.out.println(power2(n, x, count));

    }

    public static double power2(int n, int x, double count){
        if (n == 0)
            return 1;
        else{
           if (n > 1){
                count = count * x;
                n = n - 1;
            }
           else if (n < 0){
               n = -n;
               return(1 / power2(n, x, count));
           }
            else if (n == 1)  {
                return count;

            }
           return power2(n, x, count);
        }
    }
}