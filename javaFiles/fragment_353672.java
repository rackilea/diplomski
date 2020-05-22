class XArray<X> {
  private int length;
  private X[] obj;
  public XArray() {
    this.obj = initBackingArray(0);
    this.length = 0;
  }
  private X[] initBackingArray(int length) {
    @SuppressWarnings("unchecked")
    X[] result = (X[])new Object[length];
    return result;
  }
  public X get(int index) {
    return this.obj[index];
  }
  public int size() {
    return this.length;
  }
  public void add(X item) {
    insert(length, item);
  }
  public void insert( int index, X item )
  {
    if (index >= 0 && index <= length)
    {
      @SuppressWarnings("unchecked")
      X[] obj2 = (X[]) new Object[++length];
      for (int i = 0; i < index; i++)
      {
        obj2[i] = obj[i];
      }
      obj2[index] = item;
      for (int i = index; i < length - 1; i++)
      {
        obj2[i+1] = obj[i];
      }
      obj = obj2;
    }

    else
    {
      throw new java.lang.ArrayIndexOutOfBoundsException("" + index);
    }
  }
}