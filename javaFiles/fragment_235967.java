class Product {
  ...
  private Set<Upgrade> upgrades;
  ...


  public void replaceUpgrades(Set<Upgrade> newUpgrades) {
     this.upgrades.retainAll(newUpgrades);

     HashSet<T> reallyNew = new HashSet<T>(newUpgrades);
     reallyNew.removeAll(this.upgrades);

     this.upgrades.addAll(reallyNew);
  }