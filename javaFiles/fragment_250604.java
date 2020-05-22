public class DenyReturn<K,T> extends Map<K,T>{
  private Map m;
  private List<T> dontreturn;
  public DenyReturn(Map<K,T> m, List<T> dontreturn) {
    this.m = m;
    this.dontreturn = dontreturn;
  }

  public T get(Object key) {
    T val = super.get(key);
    if (dontreturn.contains(val)) return null;
    return val;
  }

  //implement all other methods of Map by invoking the inner map methods
}