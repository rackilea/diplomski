public BankAccount(String account_Number) {
  this.accountNumber= account_Number ;
}

public BankAccount(String account_Number,double iNITIAL_BALANCE)
{

  this.accountNumber = account_Number ;
  this.balance = iNITIAL_BALANCE; 
} 

public BankAccount(String account_Number, double iNITIAL_BALANCE, double 
    wITHDRAWAL_FEE,
    double aNNUAL_INTEREST_RATE) {
  this.accountNumber= account_Number ;
  this.balance= iNITIAL_BALANCE ; 
  this.annualInterestRate= aNNUAL_INTEREST_RATE ; 
  this.withdrawalFee= wITHDRAWAL_FEE ; 
}