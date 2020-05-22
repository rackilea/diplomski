public void clear() {
     removeAllElements();
 }

 public synchronized void removeAllElements() {
     modCount++;
     // Let gc do its work
     for (int i = 0; i < elementCount; i++)
         elementData[i] = null;

     elementCount = 0;
 }