@Service
public class Trader {
  /// ... your autowired dependecies

  public BigDecimal getBalance(Wallet wallet) { 
    return WalletFetcher.getWalletByAddress(wallet.getAddress()); 
  }
}