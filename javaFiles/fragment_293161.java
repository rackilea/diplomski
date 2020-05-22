apiKey.setStripeApiKey();
IfPaymentCDApp paymentCDApp = null;

try {
    String customerId = getCustomerIdByCDId(token);
    RetrieveCDCommand retrieveCDCommand = getRetrieveCDCommand(customerId, token);
    CD cD = null;
    cD = retrieveCDCommand.execute();
    paymentCDApp = AppUtils.mapStripeCDToExtCD(cD);
}