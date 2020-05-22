public int[] sort1(int[] a){
    for (int i=0; i<a.length;i++) {
        for(int j=i+1; j<a.length; j++) {
            int min = a[i];
            if (a[j] < min) {
                a[i] = a[j];
                a[j] = min;
                min = a[i];
            }
        }
    }
    return a;
}