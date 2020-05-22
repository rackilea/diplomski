private synchronized void find(){
    localBalance = myTargetAccount.balance;
    System.out.println(getName() + ": local balance = " + localBalance);
    localBalance -= 100;
    myTargetAccount.balance =  localBalance;
}