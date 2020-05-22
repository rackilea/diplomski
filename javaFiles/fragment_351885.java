public static void main(String[] args) {
    BigDecimal bd = new BigDecimal("3.001");

    bd = bd.setScale(Math.max(2, bd.scale()));
    System.out.println(bd);
}