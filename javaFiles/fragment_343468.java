public static void main(String[] args) {
    double taxes;
    Tax taxx = new Tax();
    taxes = taxx.tax1();
    System.out.printf("Your tax burden is $%.2f \n", taxes);
}