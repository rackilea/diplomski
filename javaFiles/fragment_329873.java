double annualInterestRate = 0;
    double monthlyInterest = 0;
    SavingsAccount saver1 = new SavingsAccount(2000, .03);
    SavingsAccount saver2 = new SavingsAccount(4000, .03);
    monthlyInterest = saver1.calculateMonthlyInterest();
    System.out.println("Monthly Interest at 3%: " + monthlyInterest);
    monthlyInterest = saver2.calculateMonthlyInterest();
    System.out.println("Monthly Interest at 3%: " + monthlyInterest);
    // etc