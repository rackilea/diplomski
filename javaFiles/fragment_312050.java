/**
  * Returns index for hash code h.
  */
 static int indexFor(int h, int length) {
     return h & (length-1);
 }