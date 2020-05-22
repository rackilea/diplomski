class saving_Account extends Account {
 public double calculate(double tax) {
    tax = balance * 0.05;
    return tax;
 }

 void accoutTitle(String accountTitle) {
  this.accountTitle=accountTitle;
 }

void accountNumber(String accountNumber) {
  this.accountNumber=accountNumber;
 }
}