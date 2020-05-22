// Constructor:
@Inject public BitcoinPayment(
    @Assisted long value,         // varies by instance as a constructor parameter
    BitcoinService bitcoinService // passed-in dependency satisfied by Guice
    ) { /* ... */ }

// Factory interface:
public IBitcoinPaymentFactory {
  BitcoinPayment create(long value); // users don't need to know about dependencies!
}

// Factory binding...
install(new FactoryModuleBuilder().build(IBitcoinPaymentFactory.class));

// ...which lets Guice write the equivalent of:
public GeneratedBitcoinPaymentFactory implements IBitcoinPaymentFactory {
  @Inject Provider<BitcoinService> bitcoinServiceProvider;

  @Override public BitcoinPayment create(long value) {
    return new BitcoinPayment(value, bitcoinServiceProvider.get());
  }
}