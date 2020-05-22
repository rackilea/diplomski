public static void main(String[] args) throws Exception {
    BigDecimal a = new BigDecimal("46.66");
    System.out.println("Roundup: " + roundUp(a,2) + "\nRound Down: " + roundDown(a,2));
}

public static BigDecimal roundUp(BigDecimal a, int scale)
{
    return a.setScale(scale, RoundingMode.UP);
}

public static BigDecimal roundDown(BigDecimal a, int scale)
{
    return a.setScale(scale, RoundingMode.DOWN);
}