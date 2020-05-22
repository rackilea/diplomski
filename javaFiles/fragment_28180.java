enum Whatever {
   ONE(1), TWO(2);

   private final int value;

   private Whatever(value) {
      this.value = value;
   }

   public int getValue() { return value }