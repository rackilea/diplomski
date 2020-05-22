public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage3 = new HouseBlend();
        System.out
            .println("(added by me)return value of getDescription() without condiment: " + beverage3.getDescription());
        beverage3 = new Mocha(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

        System.out.println("(added by me)value of field desciption: " + beverage3.getDescription());
    }
}

abstract class Beverage {

  protected String description = "Unknown Beverage";

  public String getDescription() {
      return description;
  }

  public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {

  public abstract String getDescription();
}

class HouseBlend extends Beverage{

  public HouseBlend() {
    description = "House Blend Coffee";
  }
  @Override
  public double cost() {
      return .89;
  }

}

class Mocha extends CondimentDecorator{

  Beverage beverage;

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