class SausageDecorator extends PizzaDecorator implements UniqueTopping {

  private String topping = "";

  public SausageDecorator(Pizza specialPizza) {
    super(specialPizza);
  }

  public String makePizza() {
    addTopping();
    return specialPizza.makePizza() + " " + getTopping();
  }

  @Override
  public String getTopping() {
    return topping;
  }

  @Override
  public void addTopping() {

     if ( !specialPizza.getTopping().equals(getTopping()) ) {
         topping = "sausage";
     }

  }

}