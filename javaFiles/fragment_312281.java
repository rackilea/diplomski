System.out.println("Deposit amount");
double depositeAmount = input.nextDouble();
save.setDeposits(depositeAmount);
System.out.println("Deposit amount");
double depositeAmount2 = input.nextDouble();
save.setDeposits(depositeAmount); // <= adds the wrong variable
System.out.println("Deposit amount");
double depositeAmount3 = input.nextDouble();
save.setDeposits(depositeAmount); // <= adds the wrong variable
System.out.println("The total amount has been deposited is " + save.getTotalAmountOfDeposits());