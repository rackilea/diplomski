class PlainPizza implements Pizza, UniqueTopping {
  @Override
  public String makePizza() {
    return "Base Pizza";
  }

  @Override
  public String getTopping() {
    return "";
  }

  @Override
  public void addTopping() {

  }

}