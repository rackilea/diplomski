public static void swapPairs(int[] a){
    int len=a.length;
        if(len%2 ==0){
            for(int i=0; i<len; i=i+2){
                int c=a[i]+a[i+1];
                a[i]=c-a[i];
                a[i+1]=c-a[i+1];
            }   
        }
        if(len%2 !=0){
            for(int j=0; j<len-1; j=j+2){
                int c=a[j]+a[j+1];
                a[j]=c-a[j];
                a[j+1]=c-a[j+1];
            }   
            a[len-1]=a[len-1];
        }   
}
public static void printArray(int[] a){
    int len=a.length;
    for(int i=0;i<len;i++)
        System.out.print(a[i]+" ");
}