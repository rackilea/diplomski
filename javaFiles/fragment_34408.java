public Spliterator<T> trySplit() {
   int lo = origin; // divide range in half
   int mid = ((lo + fence) >>> 1) & ~1; // force midpoint to be even
   if (lo < mid) { // split out left half
     origin = mid; // reset this Spliterator's origin
     return new TaggedArraySpliterator<>(array, lo, mid);
   }
   else       // too small to split
     return null;
 }