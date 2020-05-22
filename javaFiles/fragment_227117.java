@Provides
@Singleton
CreditCardProcessor providePayPalCreditCardProcessor(@Named("PayPal API key") String apiKey) {
  PayPalCreditCardProcessor processor = new PayPalCreditCardProcessor();
  processor.setApiKey(apiKey);
  return processor;
}