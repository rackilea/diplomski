public abstract class Value {

    public abstract Value get(int i);

    public abstract Value get(String s);
  }

  public  class Number extends Value {
    private Number k;
    private Object o;

    public Number(Number k) {
      super();
      this.k = k;
    }

    @Override
    public Value get(int i) {
      this.k.o = i;
      return this;
    }

     @Override
     public Value get(String s) {
       this.k.o = s;
       return this;
     }
   }