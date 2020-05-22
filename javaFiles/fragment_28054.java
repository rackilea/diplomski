Double amount = null;
String currencyCode = null;

if(listPrice != null) {
    amount = listPrice.getDouble("amount");
    currencyCode = listPrice.getString("currencyCode");
}