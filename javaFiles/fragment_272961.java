/**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

           double foo = 8.7;

            System.out.println(new BigDecimal(foo, MathContext.DECIMAL64));
            System.out.println(new BigDecimal(foo, new MathContext(16)));
            System.out.println(new BigDecimal(foo, new MathContext(17)));

            System.out.println(new BigDecimal(foo, new MathContext(1)));
            System.out.println(new BigDecimal(foo, new MathContext(2)));
            System.out.println(new BigDecimal(foo, new MathContext(3)));
            System.out.println(new BigDecimal(foo, new MathContext(15)));

            System.out.println(new BigDecimal(Double.toString(foo)));

    }