public int max(int[] arr){
    int m = 0;
    for(int i : arr){
        if(i>m){
            m = i;
        }
    }
    return m;
}