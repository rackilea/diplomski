public interface TList extends frege.runtime.Value, frege.runtime.Lazy {
  public TList.DCons _Cons() ;
  public TList.DList _List() ;
  final public static class DCons extends frege.runtime.Algebraic implements TList {
    private DCons(final java.lang.Object arg$1, final frege.runtime.Lazy arg$2) {
      mem1 = arg$1; mem2 = arg$2;
    }
    final public static TList mk(final java.lang.Object arg$1, final frege.runtime.Lazy arg$2) {
      return new DCons(arg$1, arg$2);
    }
    final public DCons _Cons() { return this; }
    final public TList.DList _List() { return null; }
    final public java.lang.Object mem1 ;
    final public frege.runtime.Lazy mem2 ;
  }
  final public static class DList extends frege.runtime.Algebraic implements TList {
    private DList() {}
    final public static TList mk() { return it; }
    final public static DList it = new DList();
    final public DList _List() { return this;}
    final public TList.DCons _Cons() { return null; }
  }
}