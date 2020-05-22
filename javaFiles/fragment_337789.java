package test;

public class J implements I {
  public static D d;
  public J(D myD) { d = myD; d.bind(this); }
  public void doThing() { System.out.println("Works!"); }
}