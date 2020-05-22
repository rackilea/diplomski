public class StoreProvider implements Provider<Store> {
  @Inject 
  private Boss boss ;

  public Store get() {
    return new Store(boss, boss.getClerk().getCustomerLine());
  }
}