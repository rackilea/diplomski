public void addElementsToArray(int element){  
  for(int i=0; i<array.length; i++)
  {
    if(array[i] == 0)
    {
      System.arraycopy(array, 0, array, 1, i);
      array[0] = element;
      return;
    }
  }
  throw new IllegalStateException("Array is full");
}