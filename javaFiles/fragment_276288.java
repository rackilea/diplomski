public class MagicSet<L> {
   private Map<L,R> forward;
   private R r;
   private Set<L> set;

   public MagicSet<L>(Map forward, R r) {
       this.forward = map;
       this.r = r;
       this.set = new HashSet<L>();
   }

   public void add(L l) {
       set.add(l);
       forward.put(l,r);
   }

   public void remove(L l) {
       set.remove(l);
       forward.remove(l);
   }

   public int size() {
       return set.size();
   }

   public in contains(L l){
       return set.contains(l);
   }

   // caution, do not use the remove method from this iterator. if this class was going
   // to be reused often you would want to return a wrapped iterator that handled the remove method properly.  In fact, if you did that, i think you could then extend AbstractSet and MagicSet would then fully implement java.util.Set.
   public Iterator iterator() {
       return set.iterator();  
   }
}



public class MagicMapper<L,R> { // note that it doesn't implement Map, though it could with some extra work.  I don't get the impression you need that though.
 private Map<L,R> forward;
 private Map<R,MagicSet<L>> inverse;

 public MagicMapper<L,R>() {
       forward = new HashMap<L,R>;
       inverse = new HashMap<R,<MagicSet<L>>;
 }


 public R getForward(L key) {
       return forward.get(key);
 }


 public Set<L> getBackward(R key) {
       return inverse.get(key);  // this assumes you want a null if
                               // you try to use a key that has no mapping.  otherwise you'd return a blank MagicSet
 }

 public void put (L l, R r) {

       R oldVal = forward.get(l);

       // if the L had already belonged to an R, we need to undo that mapping
       MagicSet<L> oldSet = inverse.get(oldVal);

       if (oldSet != null) {oldSet.remove(l);}

       // now get the set the R belongs to, and add it.
       MagicSet<L> newSet = inverse.get(l);

       if (newSet == null) {
               newSet = new MagicSet<L>(forward, r);
               inverse.put(r,newSet);
       }
       newSet.add(l);  // magically updates the "forward" map
 }


}