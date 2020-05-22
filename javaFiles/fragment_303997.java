//this is now "item2"
PaymentDetailsItemType item2 = new PaymentDetailsItemType(); 
BasicAmountType amt2 = new BasicAmountType();
amt2.setCurrencyID(CurrencyCodeType.fromValue("USD"));
double itemAmount2 = 1.00;
amt2.setValue(String.valueOf(itemAmount2));
int itemQuantity2 = 1;
item2.setQuantity(itemQuantity2);
item2.setName("item 2");
item2.setAmount(amt2);

//add item2 to your lineItems List
lineItems.add(item2);