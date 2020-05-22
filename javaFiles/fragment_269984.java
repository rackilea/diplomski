private static boolean isADouble(String s) {
    return new BigDecimal(s).equals(new BigDecimal(Double.parseDouble(s)));
}

public static void main(String[] args) {
    System.out.println(isADouble("0.1"));  // false
    System.out.println(isADouble("0.5"));  // true
}