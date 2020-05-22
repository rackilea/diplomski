public static long d(int n){
    long top = 1;
    long bom = n + 1;
    for(int q = 1; q <= n; q++){
        top *= n + q; 
        bom *= q;
    }
    return top/bom;
}