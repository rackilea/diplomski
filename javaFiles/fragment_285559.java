public static void bubbleSort(int[] x){
    for(int i=x.length - 1; i>0; i--){
        for(int j=0; j<i; j++){
            if(x[j]>x[j+1]){
                int t=x[j];
                x[j]=x[j+1];
                x[j+1]=t;
            }
        }
    }
}