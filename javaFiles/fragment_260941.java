class MyUtils {
  public static final boolean equalsWithNulls(Object a, Object b) {
    if (a==b) return true;
    if ((a==null)||(b==null)) return false;
    return a.equals(b);
  }
}