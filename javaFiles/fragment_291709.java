@SuppressWarnings("unchecked")
 public E get(int key, E valueIfKeyNotFound) {
     int i = binarySearch(mKeys, 0, mSize, key);

     if (i < 0 || mValues[i] == DELETED) {
         return valueIfKeyNotFound;
     } else {
         return (E) mValues[i];
     }
 }