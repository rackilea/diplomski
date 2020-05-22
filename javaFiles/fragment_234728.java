public abstract class BImpl<T extends B<T>> implements B<T> {
   @Override
   public T thisOrThat(T that) {
       if (that.something())
           return that;
       return this.asT();
   }


    @Override
    public boolean something() {
        // TODO Auto-generated method stub
        return false;
    }

    protected abstract T asT();
}