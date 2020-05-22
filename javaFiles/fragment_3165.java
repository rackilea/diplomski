public int returnSecondLargest(){
     int secondLargest = Integer.MIN_VALUE;
     int largest = Integer.MIN_VALUE;
     for (int i = 0; i < values.length; i++) {
         if(values[i] > values[i+1]){
             int temp = values[i];
             values[i] =values[i + 1];
             values[i+1] = temp;
         }
    }
    return values[values.length - 2];
}