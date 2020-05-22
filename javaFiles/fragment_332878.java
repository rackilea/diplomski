public int compareTo(bankAccounts b)   {
if(this.compareType == 0){
if (accountBalance < b.accountBalance)
{
    return -1;
}
if (accountBalance > b.accountBalance)  {
    return 1;
}
return 0;
}else{
 return customerName.compareTo(b.customerName)
}