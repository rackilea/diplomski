public static void newSortMethod(int[]a){
    for(int i = 0; i < a.length; i++){
        int maxPosition=i;
        int minPosition=i;
        for(int j = i+1; j < a.length - i; j++){
            if(a[j] < a[minPosition]){
                minPosition = j;
            }
            if(a[j] > a[maxPosition]){
                maxPosition = j;
            }
        }
        swap(a,minPosition,maxPosition); // <-- this line
        swap(a,maxPosition,i);
        swap(a,minPosition,a.length-i-1);
    }
}