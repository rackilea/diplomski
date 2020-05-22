public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);

    String maritalStatus;
    System.out.println("What is your marital status? Type 'M' for married and 'S' for single.");

    maritalStatus = sc.next(); //reads next input as marital status

    System.out.println("What is your annual income?");
    double income;
    income = sc.nextDouble();

    double marriedTax = 0; //declare these doubles before beginning the if/then statements
    double singleTax; 

    if (maritalStatus.equals("M")) {

        if (income > 0 && income <= 39000) {
            marriedTax = income * .15;
        }

        else if (income > 39000 && income <= 94250) {
            marriedTax = (income - 39000) * .28 + 5850;
        }

        else if (income > 94250 && income <= 143600) {
            marriedTax = (income - 94250) * .31 + 21320;
        }

        else if (income > 143600 && income <= 256500) {
            marriedTax = (income - 143600) * .36 + 36618.5;
        }

        else if (income > 256500) {

            marriedTax = (income - 256500) * 39.6 + 77262.5;
        }

        System.out.printf("Your income taxes are $%.2f.", marriedTax );
    };


    if (maritalStatus.equals("S")) {

        if (income > 0 && income <= 23350) {
            singleTax = income * .15;
        }

        else if (income > 23350 && income <= 56550) {
            singleTax = (income - 23350) * .28 + 3502.5;
        }

        else if (income > 56550 && income <= 117950) {
            singleTax = (income - 56550) * .31 + 12798.5;
        }

        else if (income > 117950 && income <= 256500) {
            singleTax = (income - 117950) * .36 + 31832.5;
        }

        else if (income > 256500); {
            singleTax = (income - 256500) * 39.6 + 81710.5;
        }

        System.out.printf("Your income taxes are $%.2f.", singleTax);
    };

    sc.close();

}