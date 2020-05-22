boolean ok = false;
while (!ok) {
    System.out.println("\nHow much money will you be withdrawing? \n(Only amounts divisible by 20 are accepted)");
    atm.withdraw = input.nextInt();
    if (atm.withdraw % 20 != 0) {
        System.out.println("Invalid withdraw amount. Please retry.");
    } else if (atm.balance < atm.withdraw) {
        System.out.println("You are not allowed to take out more then you have in your account \n Please retry");
    } else if (atm.withdraw < 0) {
        // Probably you should not allow to withdraw a negative amount of money
    } else {
        ok = true;
    }
}
atm.balance -= atm.withdraw;
System.out.println("You took out " + atm.withdraw);
System.out.println("Your new balance is $" + atm.balance);