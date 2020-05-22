static Random rand = new Random();

public static double[] generateDoubleArray(int length){
    double arr[] = new double[length];
    for(int i = 0; i<length;i++) {
        //generating random values
        arr[i] = rand.nextDouble() * 100;
    }
    return arr;
}