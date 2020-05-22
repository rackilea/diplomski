public boolean equals(CreditCard creditCard1, CreditCard creditCard2){
if (creditCard1 == null || creditCard2 == null)
    return creditCard1 == creditCard2;
boolean equalCode = (creditCard1.getCode() == creditCard2.getCode());
boolean equalCompany = creditCard1.company.equals(creditCard2.company);
boolean equalAccountNumber = (creditCard1.getAccountNumber() == creditCard2.getAccountNumber());
return equalCode && equalCompany && equalAccountNumber;
}