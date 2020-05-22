public E More ...remove(int index) {
     rangeCheck(index);

     modCount++;
     E oldValue = elementData(index);

     int numMoved = size - index - 1;
     if (numMoved > 0)
         System.arraycopy(elementData, index+1, elementData, index,
                          numMoved);
     elementData[--size] = null; // Let gc do its work

    return oldValue;
 }