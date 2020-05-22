public static String toFraction(double d, double err) {
    String s = Long.toString((long) d);
    d -= (long) d;
    if (d > err) {
        for (int den = 2, max = (int) (1 / err); den < max; den++) {
            long num = Math.round(d * den);
            double d2 = (double) num / den;
            if (Math.abs(d - d2) <= err)
                return (s.equals("0") ? "" : s + " ") + num +"/"+den;
        }
    }
    return s;
}

public static void main(String... args) {
    System.out.println(toFraction(1.0/3, 1e-6));
    System.out.println(toFraction(1.23456789, 1e-6));
    System.out.println(toFraction(Math.E, 1e-6));
    System.out.println(toFraction(Math.PI, 1e-6));
    for (double d = 10; d < 1e15; d *= 10)
        System.out.println(toFraction(Math.PI, 1.0 / d));
}