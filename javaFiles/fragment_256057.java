public static void main(String[] args) {
    List<BigDecimal> decimals = new LinkedList<>();
    decimals.add(new BigDecimal("123.123"));
    decimals.add(new BigDecimal("123.123456"));
    decimals.add(new BigDecimal("123"));
    decimals.add(new BigDecimal("0.1234445"));


    for (BigDecimal bd : decimals) {
        System.out.println(bd.toPlainString() + " ---> " + doIt(bd));
    }
}