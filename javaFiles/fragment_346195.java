enum Type{
  ABSOLUTE{
      public int apply(int newValue, int oldValue){return newValue;}
  }, INCREMENT{
      public int apply(int newValue, int oldValue){return oldValue + newValue;}
  } /* etc */
  ;
  public abstract int apply(int newValue, int oldValue);
}