public static double Average(double[] myarray) throws IllegalArgumentException {
    double dValue = 0.0;
    int counter=1;
    if (myarray== null) {
        throw new IllegalArgumentException("The array must be defined or diferent to null");
    }
    if (myarray.length == 0) {
        throw new IllegalArgumentException("The array must have size greater than zero");
    }
    for(int i = 0 ; i < myarray.length ; i++) {
        if(myarray[i] > 0.0){
            counter++;
            dValue += myarray[i];
        }
    }
    return dValue/counter;
}