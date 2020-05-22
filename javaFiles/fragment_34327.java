public static void main(String[] args) {
        BigDecimal l = new BigDecimal("12345678912345647");
        BigDecimal d = l.divide(new BigDecimal("100.00"));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        System.out.println(formatter.format(d));
    }