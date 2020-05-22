public static String toFraction(double d, int factor) {
    StringBuilder sb = new StringBuilder();
    if (d < 0) {
        sb.append('-');
        d = -d;
    }
    long l = (long) d;
    if (l != 0) sb.append(l);
    d -= l;
    double error = Math.abs(d);
    int bestDenominator = 1;
    for(int i=2;i<=factor;i++) {
        double error2 = Math.abs(d - (double) Math.round(d * i) / i);
        if (error2 < error) {
            error = error2;
            bestDenominator = i;
        }
    }
    if (bestDenominator > 1)
        sb.append(' ').append(Math.round(d * bestDenominator)).append('/') .append(bestDenominator);
    return sb.toString();
}

public static void main(String... args)  {
    System.out.println(toFraction(1.3333, 1000));
    System.out.println(toFraction(1.1428, 1000));
    for(int i=1;i<100000000;i*=10) {
        System.out.println("PI "+i+": "+toFraction(3.1415926535897932385, i));
    }
}