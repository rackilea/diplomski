enum FinancialStatementUserType {
  CONSUMER(RecipientType.CustomerPerson), 
  BUSINESS(RecipientType.CustomerPerson), 
  RETAILER(RecipientType.Seller);

  private final RecipientType recipientType;  

  FinancialStatementUserType(String recipientType) {
    this.recipientType = recipientType;
  }

  RecipientType recipientType() {
    return recipientType;
  }

}