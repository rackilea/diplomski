public class iterative {

    public static int iteration(int n) {
        int result;
        if(n==1)return n;
        else
        result = n*iteration(n-1);
     return result;
    }


    public static void main(String[] args) {
        System.out.println("Result is :" + iteration(9));
    }
}