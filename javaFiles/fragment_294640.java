public class Counter {


    public int count(int aSize, int n) {
        long[] a = new long[n+1]; // n + 1 elements since a[i] contains # of strings containing "ABC"
        a[0] = 0;
        a[1] = 0;
        a[2] = 0;


        for (int i = 3; i <= n; ++i){
            long sum = 0;
            for (int k = 0; k <= i-3; ++k) {
                sum += (pow(aSize, k) - a[k]) * pow(aSize, i - k - 3);
            }
            a[i] = sum;
        }
        return a[n];

    }

    public static void main(String... args) {
        int aSize = 3; //size of the alphabet
        int n = 30; // length of the strings

        //final result
        long result = pow(aSize, n) - count(aSize, n);


    }
}