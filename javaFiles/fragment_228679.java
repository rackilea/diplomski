86       /**
   87        * The array in which the elements of the deque are stored.
   88        * The capacity of the deque is the length of this array, which is
   89        * always a power of two. The array is never allowed to become
   90        * full, except transiently within an addX method where it is
   91        * resized (see doubleCapacity) immediately upon becoming full,
   92        * thus avoiding head and tail wrapping around to equal each
   93        * other.  We also guarantee that all array cells not holding
   94        * deque elements are always null.
   95        */
   96       private transient E[] elements;
   97   
   98       /**
   99        * The index of the element at the head of the deque (which is the
  100        * element that would be removed by remove() or pop()); or an
  101        * arbitrary number equal to tail if the deque is empty.
  102        */
  103       private transient int head;
  104   
  105       /**
  106        * The index at which the next element would be added to the tail
  107        * of the deque (via addLast(E), add(E), or push(E)).
  108        */
  109       private transient int tail;