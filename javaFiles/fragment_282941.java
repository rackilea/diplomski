private static double getMinValue(double[] rain) {

    double min=Double.MAX_VALUE;
    for(double i : rain){
       if(i<min){
         min=i;
       }
    }
    return min;
}