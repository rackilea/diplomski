public static void main(String[] args) {
    NumberFormat formatter = new DecimalFormat();

    double num1 = 2E6;
    formatter = new DecimalFormat("##########");
    System.out.println(formatter.format(num1)); 

    double num2 = 3.3e-5;
    formatter = new DecimalFormat("#.##########");
    System.out.println(formatter.format(num2));
}