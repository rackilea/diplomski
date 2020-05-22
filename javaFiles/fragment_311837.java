public class IteratorFunctor<A> {

  public final Iterator<A> i;

  private IteratorFunctor(Iterator<A> _i) {
    i = _i;
  }

  public <B> IteratorFunctor<B> map(Fn1<A,B> f) {
    List<B> bs = new LinkedList<B>();
    while (i.hasNext()) {
      bs.add(f.apply(i.next()));
    }
    return apply(bs.iterator());
  }

  public static <A> IteratorFunctor<A> apply(Iterator<A> _i) {
    return new IteratorFunctor<A>(_i);
  }

}