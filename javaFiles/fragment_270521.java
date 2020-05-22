public static double roundToHalf(double d) {
    return Math.round(d * 2) / 2.0;
}

public static void main(String[] args) {
    double d1 = roundToHalf(1.1);
    double d2 = roundToHalf(1.3);
    double d3 = roundToHalf(2.5);
    double d4 = roundToHalf(3.223920);
    double d5 = roundToHalf(3);

    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);
    System.out.println(d4);
    System.out.println(d5);
}