enum Message {
   A() {
      @Override
      public boolean conditionsMet() {
          ...
      }
   },
   B() {
      @Override
      public boolean conditionsMet() {
          ...
      }
   },
   ...
   ;
   public abstract boolean conditionsMet();
}