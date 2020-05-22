public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    final double TAX = .1;
    final double TAX1 = .15;
    final double TAX2 = .25;
    final double TAX3 = .28;
    final double TAX4 = .33;
    final double TAX5 = .35;
    final double TAX6 = .396;

    final int INCOME = 9075;
    final int INCOME1 = 36900;
    final int INCOME2 = 89350;
    final int INCOME3 = 186350;
    final int INCOME4 = 405100;
    final int INCOME5 = 406750;

    double all = 0;
    for (int i = 0; i < 5; i++) {
        System.out.println("");
        System.out.println("Enter your yearly income");
        double year_Income = in.nextDouble();

        if (year_Income <= 9074) {
            System.out.println("Your tax is 10%");
            double taxes = ((double) year_Income * TAX);
            System.out.println("You Owe" + taxes);
            all += taxes;
        } else if (year_Income >= INCOME && year_Income <= INCOME1) {
            System.out.println("Your tax is 15%");
            double taxes = ((double) year_Income * TAX1);
            System.out.println("You Owe" + taxes);
            all += taxes;
        } else if (year_Income >= INCOME1 && year_Income <= INCOME2) {
            System.out.println("Your tax is 25%");
            double taxes = ((double) year_Income * TAX2);
            System.out.println("You Owe" + taxes);
            all += taxes;
        } else if (year_Income >= INCOME2 && year_Income <= INCOME3) {
            System.out.println("Your tax is 28%");
            double taxes = ((double) year_Income * TAX3);
            System.out.println("You Owe" + taxes);
            all += taxes;
        } else if (year_Income >= INCOME3 && year_Income <= INCOME4) {
            System.out.println("Your tax is 33%");
            double taxes = ((double) year_Income * TAX4);
            System.out.println("You Owe" + taxes);
            all += taxes;
        } else if (year_Income >= INCOME4 && year_Income <= INCOME5) {
            System.out.println("Your tax is 35%");
            double taxes = ((double) year_Income * TAX5);
            System.out.println("You Owe" + taxes);
            all += taxes;
        } else {
            System.out.println("Your tax is 39.6");
            double taxes = ((double) year_Income * TAX6);
            System.out.println("You Owe" + taxes);
            all += taxes;
        }
    }
    System.out.println("Total Taxes : "+all);

    in.close();
}