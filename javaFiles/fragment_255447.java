public static void main(String[] args){
    int array1[][] = {{90, 80, 65, 100}, {55, 94, 86}, {82}, {77, 100}};
    double maxAverage = Double.MIN_VALUE;
    for(int[] sub : array1){                       //iterate over sub-arrays
        double average = averageOfArray(sub);      //compute its average
        maxAverage = Math.max(maxAverage, average);//get the max of it and the previous max
    }
    System.out.printn(maxAverage)
}

static double averageOfArray(int[] array){
    double sum = 0;
    for(int i=0; i<array.length; i++){
        sum += array[i];
    }   
    return sum/array.length;
}