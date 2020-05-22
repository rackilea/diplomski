public class Tetris {
    public static int sumOfProd(int n)  {
        int sum = 0;
        int i = 2;
        while (i <= n){ 
            sum = sum + (2*i-1)*(2*i);
            i = i+2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfProd(10));
    }

}