public enum Symbol {
   ALPHA("alpha"),
   BETA("beta");

   private final String value;

   private Symbol(String value) {
     this.value = value;
   }

   public String getValue() {
     return value;
   }
}