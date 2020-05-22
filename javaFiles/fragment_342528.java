String currencyCode = "";
if (dataFormat.contains("$$")) {
    currencyCode = "USD";
}
else if (dataFormat.contains("$€")) {
    currencyCode = "EUR";
}
moneyCurrency = new Money(bd, currencyCode);