class Parent {
  private int x;
  protected int y;
  public int z;
}

class Child extends Parent {
  public void doit(){ System.out.println(x); //compiler error }
  public void doit2(){ System.out.println(y); //allowed }
  public void doit3(){ System.out.println(z); //allowed }
}