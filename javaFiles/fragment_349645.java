public static double intRiemann(double a, double b, double n){
    double width = (b - a) / n;
    double sum = 0.0;

    for (int i = 0; i < n; i++) {
        double first_mid_p=a + (width / 2.0) + i * width;
        sum = sum + (first_mid_p*first_mid_p-first_mid_p+3);
    }

    return sum * width;
}


public static void main(String[] args){
    System.out.println( intRiemann(-5.0,12.0,40.0));
}