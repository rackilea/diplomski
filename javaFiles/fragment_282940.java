private static double getMaxValue(double[] rain) {

    double max=0;
    for(double i : rain){
       if(i>max){
         max=i;
       }
    }
    return max;
}