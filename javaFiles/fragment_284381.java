public final class Pair<U,V> {
   public final U first;
   public final V second;
   public Pair(U u, V v) {
      this.first = u;
      this.second = v;
   }
   public String toString() {
      return "["+first+","+second+"]";
   }
}