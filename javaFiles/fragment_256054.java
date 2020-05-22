public static void main(String[] args) {
    List<BigDecimal> decimals = new LinkedList<>();
    decimals.add( new BigDecimal(".123456"));
    decimals.add( new BigDecimal("1.23456"));
    decimals.add( new BigDecimal("12.3456"));
    decimals.add( new BigDecimal("123.456"));
    decimals.add( new BigDecimal("1234.56"));
    decimals.add( new BigDecimal("12345.6"));
    decimals.add( new BigDecimal("123456"));

    for(BigDecimal bd : decimals){
        System.out.println(bd.toPlainString() + ". scale = " + bd.scale() + ", precision = " + bd.precision());
    }
}