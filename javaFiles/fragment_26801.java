public static void main(String[] args) {
    Fraction twentyFour = Fraction.of(BigDecimal.valueOf(24));
    Fraction fraction = Fraction.ONE.divide(twentyFour);
    System.out.println("Fraction = " + fraction);

    Fraction count = new Fraction(BigDecimal.ZERO, BigDecimal.ONE);
    for (int i = 1; i <= 24; i++) {
        count = count.add(fraction);
    }

    if (BigDecimal.ONE.equals(count.value())) {
        System.out.println("100%");
    } else {
        System.out.println(count);
    }
}