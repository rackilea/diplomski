651       public synchronized void removeAllElements() {
  652           modCount++;
  653           // Let gc do its work
  654           for (int i = 0; i < elementCount; i++)
  655               elementData[i] = null;
  656   
  657           elementCount = 0;
  658       }