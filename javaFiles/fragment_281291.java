/**
  * Encapsulates 2 X's and a List
  */
public class Y {

  private X x1;
  private X x2;
  private List list;

  public Y() {
    list = //..create list
    x1 = new X(list);
    x2 = new X(list);
  }
}