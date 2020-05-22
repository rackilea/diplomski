package jsortbu;
import java.util.Random;

public class jsortbu {
    static void MergeSort(int[] a)          // entry function
    {
        if(a.length < 2)                    // if size < 2 return
            return;
        int[] b = new int[a.length];
        BottomUpMergeSort(a, b);
    }

    static void BottomUpMergeSort(int[] a, int[] b)
    {
    int n = a.length;
    int s = 1;                              // run size 
        if(1 == (GetPassCount(n)&1)){       // if odd number of passes
            for(s = 1; s < n; s += 2)       // swap in place for 1st pass
                if(a[s] < a[s-1]){
                    int t = a[s];
                    a[s] = a[s-1];
                    a[s-1] = t;
                }
            s = 2;
        }
        while(s < n){                       // while not done
            int ee = 0;                     // reset end index
            while(ee < n){                  // merge pairs of runs
                int ll = ee;                // ll = start of left  run
                int rr = ll+s;              // rr = start of right run
                if(rr >= n){                // if only left run
                    do{                     //   copy it
                        b[ll] = a[ll];
                        ll++;
                    }while(ll < n);
                    break;                  //   end of pass
                }
                ee = rr+s;                  // ee = end of right run
                if(ee > n)
                    ee = n;
                Merge(a, b, ll, rr, ee);
            }
            {                               // swap references
                int[] t = a;
                a = b;
                b = t;
            }
            s <<= 1;                        // double the run size
        }
    }

    static void Merge(int[] a, int[] b, int ll, int rr, int ee) {
        int o = ll;                         // b[]       index
        int l = ll;                         // a[] left  index
        int r = rr;                         // a[] right index
        while(true){                        // merge data
            if(a[l] <= a[r]){               // if a[l] <= a[r]
                b[o++] = a[l++];            //   copy a[l]
                if(l < rr)                  //   if not end of left run
                    continue;               //     continue (back to while)
                while(r < ee){              //   else copy rest of right run
                    b[o++] = a[r++];
                }
                break;                      //     and return
            } else {                        // else a[l] > a[r]
                b[o++] = a[r++];            //   copy a[r]
                if(r < ee)                  //   if not end of right run
                    continue;               //     continue (back to while)
                while(l < rr){              //   else copy rest of left run
                    b[o++] = a[l++];
                }
                break;                      //     and return
            }
        }
    }

    static int GetPassCount(int n)          // return # passes
    {
        int i = 0;
        for(int s = 1; s < n; s <<= 1)
            i += 1;
        return(i);
    }

    public static void main(String[] args) {
        int[] a = new int[10000000];
        Random r = new Random();
        for(int i = 0; i < a.length; i++)
            a[i] = r.nextInt();
        long bgn, end;
        bgn = System.currentTimeMillis();
        MergeSort(a);
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