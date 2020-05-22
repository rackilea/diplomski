public static void main(String[] args) {
    DecimalFormat decimalFormat = new DecimalFormat("#0.000");
    double d = 1 - .9; // one way to get a repeating decimal floating point number 
    System.out.println(d);
    System.out.println(decimalFormat.format(d));
}