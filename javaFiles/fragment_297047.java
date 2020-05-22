public static void main(String[] args) {
    int income = 1000000;  // Sample test amount of income, should result in 327,683.50 in taxes.
    double tax = 0;
    if (income > 0) {
        tax = income * 0.10;
        tax += (Math.max(0, income-8350)) * 0.05;
        tax += (Math.max(0, income-33950)) * 0.10;
        tax += (Math.max(0, income-82250)) * 0.03;
        tax += (Math.max(0, income-171550)) * 0.05;
        tax += (Math.max(0, income-372950)) * 0.02;
    }
    System.out.println("Tax: "  + tax);
}