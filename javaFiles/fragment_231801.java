public static BigDecimal calculatePi(int decimals) {
    BigDecimal pi = new BigDecimal(3);
    boolean toggle = true;
    boolean enough = false;
    int i = 2;

    while (!enough) {
        BigDecimal a = new BigDecimal(4); // All operation must be using only BigDecimal 
        BigDecimal b = new BigDecimal(i).multiply(new BigDecimal(i + 1)).multiply(new BigDecimal(i + 2));
        BigDecimal num = a.divide(b, 100, RoundingMode.FLOOR);
        System.out.println(i / 2);

        if (toggle) {
            pi = pi.add(num);
            toggle = false;

        } else {
            pi = pi.subtract(num);
            toggle = true;
        }
        i += 2;

        if (PI.substring(0, decimals + 2).equals(("" + pi).substring(0, decimals + 2))) {
            enough = true;
        }
    }
    return pi;
}