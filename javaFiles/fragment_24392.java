public class SignBuyEvent implements Listener{
  @EventHandler
  public void onSignBuy(SSMoneyTransactionEvent event){
    Bukkit.getServer().broadcastMessage("one!");
  }

  @EventHandler
  public void onSignBuy(SSPreTransactionEvent event){
    Bukkit.getServer().broadcastMessage("two!");
  }

  @EventHandler
  public void onSignBuy(SSPostTransactionEvent event){
    Bukkit.getServer().broadcastMessage("three!");
  }

  @EventHandler
  public void onSignBuy(SSTouchShopEvent event){
    Bukkit.getServer().broadcastMessage("four!");
  }
}