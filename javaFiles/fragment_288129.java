public static void main(String[] args) {
    System.out.println(castRoundTo2(1375568.13000015));
    System.out.println(castRoundTo2(1375568.13124765));

    System.out.println(round2(-1375568.13000015));
    System.out.println(round2(-1375568.13124765));
}

public static double castRoundTo2(double d) {
    return (long) (d * 100 + 0.5) / 100.0;
}

public static double round2(double d) {
    return roundToFactor(d, 100);
}

public static double roundToFactor(double d, double f) {
    return Math.round(d * f) / f;
}