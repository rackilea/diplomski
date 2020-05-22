private static int[] sqeeze2(int [] a){
    int index = 0;
    if(a.length == 0)
        return a;
    for(int i=0;i<a.length;i++){
        if(a[i] !=0 && index < a.length){
            a[index] = a[i];
            a[i]=0;
            index++;
        }
    }
    return a;
}