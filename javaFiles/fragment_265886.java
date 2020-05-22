public static void triangular(int start, int n){
    if(start > n)
        return;
    int triangular = (start*(start+1))/2;
    System.out.println(triangular);
    triangular(start+1,n);
}