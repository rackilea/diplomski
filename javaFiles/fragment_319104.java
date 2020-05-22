public static sin(int n) {
    // angle to radians
    double rad = n*1./180.*Math.PI;
    // the first element of the taylor series
    double sum = rad;
    // add them up until a certain precision (eg. 10)
    for (int i = 1; i <= PRECISION; i++) {
        if (i % 2 == 0) 
            sum += Math.pow(rad, 2*i+1) / factorial(2 * i + 1);
        else 
            sum -= Math.pow(rad, 2*i+1) / factorial(2 * i + 1);
    }
    return sum;
}