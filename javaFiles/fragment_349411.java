public class Ooops<P, O> implements Comparable<Ooops<P,O>> {

  private P po;
  private O pa;

  @Override
  public int compareTo(Ooops<P, O> o) {
    return (po.toString()+pa.toString()).compareTo(o.po.toString()+o.pa.toString());   //Some common way to compare the two.
  }
}