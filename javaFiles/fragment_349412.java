public class Ooops<P extends Comparable<P>, O extends Comparable<O>> implements Comparable<Ooops<P,O>> {

  private P po;
  private O pa;

  @Override
  public int compareTo(Ooops<P, O> o) {
    if (po.compareTo(o.po) == 0)
      return pa.compareTo(o.pa);
    else
      return po.compareTo(o.po);
  }
}