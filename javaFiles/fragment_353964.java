double total(int N, double[] d, double[] c, double a, double b) {

    double sum           = 0.0;
    double running_error = 0.0;

    for (int i = 0; i != N; ++i) {
        if (d[i] == 0.0)
            continue;

        if (c[i] == 0.0)
            throw "XXX"; // some error reporting

        double v = 0.0;
        if (d[i] > 0.0 && c[i] > 0.0) {
            // using log trick, if you want
            double lpi = a*Math.log(d[i]) - b*Math.log(c[i]);
            v = Math.exp(lpi);   
        }
        else {
            v = Math.pow(d[i], a) * Math.pow(1.0/c[i], b);
        }

        double difference = v - running_error;
        double temp = sum + difference;
        running_error = (temp - sum) - difference;
        sum = temp;
     }
     return sum;
}