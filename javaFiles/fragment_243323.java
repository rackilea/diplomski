public int findMinimum(int[] array){
    int minIndex = 0;
    for(int i = 1; i < array.length; i++){
        if(array[i] < array[minIndex]){
            minIndex = i;
        }
    }
    return minIndex;
}