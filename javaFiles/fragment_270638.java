@Test
public void printMathCalculation() {
    double libValue = Math.log(100); 
    double myValue = getLn(100);

    System.out.println("Actual: \t" + libValue);
    System.out.println("Approximate: \t" + myValue);
}

//Take double to an integer power
private double pow(double num, int power) {
    double result = 1;

    for(int i = 0; i < power; i++) {
        result *= num;
    }
    return result;
}

//Get natural log
private double getLn(double num) {
    int accuracy = 1000;
    double sum = 0;
    for(int n = 0; n < accuracy; n++) {
        double num1 = (1.0/(2*n+1));
        double num2 = (num-1)/(num+1);

        sum += num1*pow(num2,2*n+1);
    }

    return 2 * sum;
}