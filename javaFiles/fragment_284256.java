do {
     System.out.println("Please enter the interest rate on your loan, must be >= 0:");
     interestRate = keyboard.nextDouble();
  }  while (interestRate < 0.0);
  interestRate*=100.0;
  String str = "";
  do {
     interestRate = (interestRate/100.0);
     System.out.print(str);
     str="Interest rates must be entered as decimal values less than" +
     " 1.0. Interest rate will be saved as " + interestRate/100.0 + "\n";
  }  while (interestRate > 1.0);