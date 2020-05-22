public static void main (String[] args){
    TimeDepositAccount tda = new TimeDepositAccount(10,2);
    double currentBalance = tda.getcurrentBalance();
    System.out.println(currentBalance);
    tda.newBalance();
    currentBalance = tda.getcurrentBalance();
    System.out.print(currentBalance);
}