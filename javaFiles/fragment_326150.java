public enum Employee { // changed "class" to "enum"

   INSTANCE; // added name of the (single) instance

   private int id; 
   private String name; 
   Employee() {} // removed "public"
   public int getId() {
      return id; 
   }
   public void setId( int id ) { 
      this.id = id; 
   } 
   public String getName() { 
      return name; 
   } 
   public void setName( String name ) {
      this.name = name; 
   }
}