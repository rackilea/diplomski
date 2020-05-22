public interface BondType {
  public double calculate();
}

public class BOT implements BondType { 
  //...
}

public class Bond {
  private BondType type;
  public Bond(BondType type) {
    this.type = type;
  }
  public doublce calculateValue() {
    return type.calculate();
  }
}