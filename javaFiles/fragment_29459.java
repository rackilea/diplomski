while (true) {
   Node<E> curTail = tail.get();
   Node<E> residue = curTail.next.get();

   /* (i) */

   if (curTail.next.compareAndSet(null, newNode)) /* C */ {
     tail.compareAndSet(curTail, newNode) /* D */ ;
     return true;
   } else {
      tail.compareAndSet(curTail, residue) /* B */;
   }
}