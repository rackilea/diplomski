public class SuperClass {
  public SuperClass() {
    System.out.println(getValue());
  }   

  public String getValue() {
    return "superclass";
  }   

  public static void main(String[] args) {
    new SubClass();
  }   

  public static class SubClass extends SuperClass {
    public String getValue() {
      return super.getValue() + " subclass";
    }   
  }   
}