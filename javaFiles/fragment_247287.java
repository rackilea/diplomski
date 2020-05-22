public enum StatAction {
   MAKE_2_PTS("Make Two Points"), MISS_2_PTS("Miss Two Points"), 
   MAKE_3_PTS("Make Three Points");

   private String text;

   private StatAction(String text) {
      this.text = text;
   }

   @Override
   public String toString() {
     return text;
   }

   public String getText() {
      return text;
   }

}