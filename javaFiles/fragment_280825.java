public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage3 = new HouseBlend();
        System.out
            .println("(added by me)return value of getDescription() without condiment: " + beverage3.getDescription());
        beverage3 = new Mocha(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

        System.out.println("(added by me)value of field desciption: " + beverage3.description);
    }

}

abstract class Beverage {

  protected String description = "Unknown Beverage";

  public abstract String getDescription();

  public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    // You don't need this code here. Because Beverage already 
    // provides a getDescription
  // public abstract String getDescription();
}

class HouseBlend extends Beverage{

  public HouseBlend() {
    description = "House Blend Coffee";
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public double cost() {
      return .89;
  }

}

class Mocha extends CondimentDecorator{
  // Also make sure that this guy here is private
  // so other objects can't change or access 
  // its state without going through Mocha
  private Beverage beverage;

  public Mocha(Beverage beverage) {
      this.beverage = beverage;
  }

  @Override
  public String getDescription() {
      return beverage.getDescription() + ", Mocha";
  }

  @Override
  public double cost() {
      return beverage.cost() + .20;
  }

}