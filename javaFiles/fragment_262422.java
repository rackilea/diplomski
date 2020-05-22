static final int MINSIZE = 32;          // must be >= 3

    static void InsertionSort(Integer a[], int ll, int rr)
    {
    int i = ll+1;
    int j;
    Integer t;
        while(i < rr){
            t = a[i];
            j = i;
            while((j > ll) && a[j-1].compareTo(t)> 0){
                a[j] = a[j-1];
                j -= 1;}
        a[j] = t;
        i += 1;}
    }

    public static void MergeSort(Integer[] a)  // entry function
    {
        if(a.length < 2)                    // if size < 2 return
            return;
        Integer[] b = new Integer[a.length];
        MergeSortAtoA(a, b, 0, a.length);

    }

    static void MergeSortAtoA(Integer[] a, Integer[] b, int ll, int rr)
    {
        if(rr - ll <= MINSIZE){
            InsertionSort(a, ll, rr);
            return;}
        int m1 = ll+(rr+0-ll)/4;
        int m2 = m1+(rr+1-ll)/4;
        int m3 = m2+(rr+2-ll)/4;
        MergeSortAtoB(a, b, ll, m1);
        MergeSortAtoB(a, b, m1, m2);
        MergeSortAtoB(a, b, m2, m3);
        MergeSortAtoB(a, b, m3, rr);
        Merge(b, a, ll, m1, m2, m3, rr);
    }

    static void MergeSortAtoB(Integer[] a, Integer[] b, int ll, int rr)
    {
        if(rr - ll <= MINSIZE){
            System.arraycopy(a, ll, b, ll, rr-ll);
            InsertionSort(b, ll, rr);
            return;}
        int m1 = ll+(rr+0-ll)/4;
        int m2 = m1+(rr+1-ll)/4;
        int m3 = m2+(rr+2-ll)/4;
        MergeSortAtoA(a, b, ll, m1);
        MergeSortAtoA(a, b, m1, m2);
        MergeSortAtoA(a, b, m2, m3);
        MergeSortAtoA(a, b, m3, rr);
        Merge(a, b, ll, m1, m2, m3, rr);
    }

    static void Merge(Integer[] a, Integer[] b, int ll, int m1, int m2, int m3, int rr) {
        int bb = ll;                        // b[] index
        int a0 = ll;                        // a[] indexes
        int a1 = m1;
        int a2 = m2;
        int a3 = m3;
        while(true){                        // 4 way merge
            int sr;                         // smallest run
            if(a[a0].compareTo(a[a1]) <= 0){
                if(a[a2].compareTo(a[a3]) <= 0){
                    if(a[a0].compareTo(a[a2]) <= 0){
                        sr = 0;}
                    else{
                        sr = 2;}}
                else{
                    if(a[a0].compareTo(a[a3]) <= 0){
                        sr = 0;}
                    else{
                        sr = 3;}}}
            else{
                if(a[a2].compareTo(a[a3]) <= 0){
                    if(a[a1].compareTo(a[a2]) <= 0){
                        sr = 1;}
                    else{
                        sr = 2;}}
                else{
                    if(a[a1].compareTo(a[a3]) <= 0){
                        sr = 1;}
                    else{
                        sr = 3;}}}
            if(sr == 0){
                b[bb] = a[a0];
                bb++;
                a0++;
                if(a0 < m1)
                    continue;
                a0 = a1;
                a1 = a2;
                a2 = a3;
                m1 = m2;
                m2 = m3;
                m3 = rr;
                break;}
            if(sr == 1){
                b[bb] = a[a1];
                bb++;
                a1++;
                if(a1 < m2)
                    continue;
                a1 = a2;
                a2 = a3;
                m2 = m3;
                m3 = rr;
                break;}
            if(sr == 2){
                b[bb] = a[a2];
                bb++;
                a2++;
                if(a2 < m3)
                    continue;
                a2 = a3;
                m3 = rr;
                break;}
            else{  // sr == 3
                b[bb] = a[a3];
                bb++;
                a3++;
                if(a3 < rr)
                    continue;
                break;}
        }
        while(true){                        // 3 way merge
            int sr;                         // smallest run
            if(a[a0].compareTo(a[a1]) <= 0){
                if(a[a0].compareTo(a[a2]) <= 0){
                    sr = 0;}
                else{
                    sr = 2;}}
            else{
                if(a[a1].compareTo(a[a2]) <= 0){
                    sr = 1;}
                else{
                    sr = 2;}}
            if(sr == 0){
                b[bb] = a[a0];
                bb++;
                a0++;
                if(a0 < m1)
                    continue;
                a0 = a1;
                a1 = a2;
                m1 = m2;
                m2 = m3;
                break;}
            if(sr == 1){
                b[bb] = a[a1];
                bb++;
                a1++;
                if(a1 < m2)
                    continue;
                a1 = a2;
                m2 = m3;
                break;}
            else{ // sr == 2
                b[bb] = a[a2];
                bb++;
                a2++;
                if(a2 < m3)
                    continue;
                break;}
        }
        while(true){                        // 2 way merge
            if(a[a0].compareTo(a[a1]) <= 0){
                b[bb] = a[a0];
                bb++;
                a0++;
                if(a0 < m1)
                    continue;
                a0 = a1;
                m1 = m2;
                break;}
            else{
                b[bb] = a[a1];
                bb++;
                a1++;
                if(a1 < m2)
                    continue;
                break;}
        }
        System.arraycopy(a, a0, b, bb, m1-a0);  // 1 way copy
    }