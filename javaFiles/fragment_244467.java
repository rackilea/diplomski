public class ArrayExample {
public static void main (String[] args) {
    int[] a = {2,2,2,2};
    int[] b = {2,2,2,2};
    int n = a.length;
    int result = recurseSum(a, b, n-1);
    System.out.println(result);
}

public static int recurseSum(int[] a, int[] b, int n){
    if(n == 0)
        return a[0]*b[0];
    else{
        return (a[n] * b[n]) + recurseSum(a,b,n-1);
    }
}
}