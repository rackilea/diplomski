public static double futureInvestmentValue(final double investmentAmmnt, double mri, int years)
  {
    NumberFormat df = DecimalFormat.getCurrencyInstance(Locale.US);
    double amount = investmentAmmnt;

    System.out.println("The amount invested: " + (df.format(investmentAmmnt)));
    System.out.println("Annual interest rate: " + mri);
    System.out.println("Years \t \t Future Value");
    for (int i = 1; i <= years ; i++){
      amount = investmentAmmnt * Math.pow(1 + (mri /100),(i ));
    System.out.println(i  + "\t\t" + (df.format(amount)));
    }
    return amount;
  }