Scanner input = new Scanner(System.in);
    String userInput = null;
    for (int i = 0; i < 30; i++)
    {
      for (int j = 0; j < 12; j++)
      {
        double interestPaid = balanceRemaining * .0575 / 12;
        double principalPaid = monthlyPayment - interestPaid;
        balanceRemaining = balanceRemaining - principalPaid;
        System.out.println("Month " + (i*12+j + 1) + 
                 " \tPayment Amount: $" + currency.format(monthlyPayment) + 
                "\tInterest Paid: $" + currency.format(interestPaid) + 
                " \tPrincipal Paid: $" + currency.format(principalPaid) + 
                "    \tBalance Remaining: $" + currency.format(balanceRemaining));
      }
      userInput = input.nextLine();
    }
    input.close();