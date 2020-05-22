public void add(int index, E element) {
     rangeCheckForAdd(index);
     ensureCapacity(size+1);  // Increments modCount!!
     System.arraycopy(elementData, index, elementData, index + 1, size - index);
     elementData[index] = element;
     size++;
 }