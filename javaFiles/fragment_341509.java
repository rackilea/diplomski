public interface Ix<A>{
   public List<A> range(A start,A end);
   public int index(A start,A end,A el);
   public boolean inRange(A start,A end,A el);
   public int rangeSize(A start,A end);
}