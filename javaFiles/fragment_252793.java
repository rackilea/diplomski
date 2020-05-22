public boolean charge(double price) {
    boolean isSuccess = super.charge(price);
    if(!isSuccess)
       charge(5); //penalty for late fee
     return isSuccess;
 }