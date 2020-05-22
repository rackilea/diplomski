public class nested_radical {

public nested_radical() {
    int n = 1;
    double x = 0, y = 0, p = 1;
    while ( p > 10e-6) { 
        y=x;             /*stored the value of loop(n - 1) instead of recomputing*/
        x = loop(n);
        p = x - y;
        n++;
    }
    System.out.println("value of given expression = " + x);
    System.out.println("Iterations required = " + n);
}

public double loop(int n) {
    double sum = 0;
    while (n > 0) {
        sum = Math.sqrt(sum + n--);
    }
    return (sum);
}


public static void main(String[] args) {
    new nested_radical();
}

}