public static void main(String args[]) {
    //trying to use numbers with an exact double representation
    double d1 = 0.5;
    double d2 = 0.000030517578125;
    double d3 = 0.00000095367431640625;

    BigDecimal bd1 = new BigDecimal(d1);
    BigDecimal bd2 = new BigDecimal(d2);
    BigDecimal bd3 = new BigDecimal(d3);

    System.out.println(d1 + "\t\t\t" + bd1);
    System.out.println(d2 + "\t\t" + bd2);
    System.out.println(d3 + "\t" + bd3);
}