class PairKey<T extends Comparable<T>> { 
  final T fst, snd;
  public PairKey(T a, T b) {
    if (a.compareTo(b) <=0 ) {
      fst = a;
      snd = b;
    } else {
      fst = b;
      snd = a;
    }
  }

  @Override
  public int hashCode() {
    return a.hashCode() & 37 & b.hashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceOf PairKey)) return false;
    PairKey<T> obj = (PairKey<T>) other;
    return (obj.fst.equals(fst) && obj.snd.equals(snd));
  }
}