package msortih;
import java.util.Random;

public class msortih {

    static final int S = 64;    // use insertion sort if size <= S

    static void swap(int[] a, int i, int j) {
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }

    // a[w:] = merged a[i:m]+a[j:n]
    // a[i:] = reordered a[w:]
    static void wmerge(int[] a, int i, int m, int j, int n, int w) {
        while (i < m && j < n)
            swap(a, w++, a[i] < a[j] ? i++ : j++);
        while (i < m)
            swap(a, w++, i++);
        while (j < n)
            swap(a, w++, j++);
    }  

    // a[w:]  = sorted    a[b:e]
    // a[b:e] = reordered a[w:]
    static void wsort(int[] a, int b, int e, int w) {
        int m;
        if (e - b > 1) {
            m = b + (e - b) / 2;
            imsort(a, b, m);
            imsort(a, m, e);
            wmerge(a, b, m, m, e, w);
        }
        else
            while (b < e)
                swap(a, b++, w++);
    }

    // inplace merge sort a[b:e]
    static void imsort(int[] a, int b, int e) {
        int m, n, w, x;
        int t;
        // if <= S elements, use insertion sort
        if (e - b <= S){
            for(n = b+1; n < e; n++){
               t = a[n];
               m = n-1;
                while(m >= b && a[m] > t){
                    a[m+1] = a[m];
                    m--;}
                a[m+1] = t;}
            return;
        }
        if (e - b > 1) {
            // split a[b:e]
            m = b + (e - b) / 2;
            w = b + e - m;
            // wsort -> a[w:e] = sorted    a[b:m]
            //          a[b:m] = reordered a[w:e]
            wsort(a, b, m, w);
            while (w - b > 2) {
                // split a[b:w], w = new mid point
                n = w;
                w = b + (n - b + 1) / 2;
                x = b + n - w;
                // wsort -> a[b:x] = sorted    a[w:n]
                //          a[w:n] = reordered a[b:x]
                wsort(a, w, n, b);
                // wmerge -> a[w:e] = merged    a[b:x]+a[n:e]
                //           a[b:x] = reordered a[w:n]
                wmerge(a, b, x, n, e, w);
            }
            // insert a[b:w] into a[b:e] using left shift
            for (n = w; n > b; --n) {
                t = a[n-1];
                for (m = n; m < e && a[m] < t; ++m)
                    a[m-1] = a[m];
                a[m-1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[16*1024*1024];
        Random r = new Random(0);
        for(int i = 0; i < a.length; i++)
            a[i] = r.nextInt();
        long bgn, end;
        bgn = System.currentTimeMillis();
        imsort(a, 0, a.length);
        end = System.currentTimeMillis();
        for(int i = 1; i < a.length; i++){
            if(a[i-1] > a[i]){
                System.out.println("failed");
                break;
            }
        }
        System.out.println("milliseconds " + (end-bgn));
    }
}