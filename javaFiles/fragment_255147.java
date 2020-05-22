static void mergeArray(int []a, int []b, int m ){
    int[] c= new int[100001];
       System.arraycopy(a, 0, c, 0, m);
       System.arraycopy(b, 0, c, m, m*2);
       System.arraycopy(c, 0, b, 0, m*2);
}