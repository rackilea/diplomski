public enum MyEnum {
   ONE(1),
   TWO(2);
   private int value;
   private MyEnum(int value) {
      this.value = value;
   }
   public int getValue() {
      return value;
   }
}