public static void printWeightAVG(int[] value) {

    int sum =0;
    for(int count=0; count<value.length; count++) {
       sum = sum + value[count];
    }
    //double average = ((int)sum/ 28.0); (as in your code)
    double average = sum/value.length; //(better way)
    System.out.println("The average weight is " + average + " lbs.");
}