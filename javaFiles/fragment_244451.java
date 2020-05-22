public enum Color{
 RED("Red"), GREEN("Green");

 private Color(String color){
    this.color = color;
  }

  private String color;

  public String getColor(){
    return this.color;
  }

  public void setColor(String color){
    this.color = color;
  }

  public String toString(){
    return this.color;
  }
}