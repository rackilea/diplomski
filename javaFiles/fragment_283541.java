if(account1.withDrawal(wD)) {
   System.out.printf("%n%s Balance: %.2f" , account1.getName(),account1.getBalance());
}
else {
   System.out.println("\nInsufficient Balance");
}