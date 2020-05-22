public enum Color
{
   //[PROP]
   RED("red"),
   GREEN("green"),
   BLUE("blue");

   private String value;
   public String getValue {return value;}

   //[BUILD]
   Color(String value) {this.value = value;}

   //[UTIL]
   Color[] getKeys() {return this.values;} //values method is already a method existing in enum class, we are just proposing another method name here as a facade for simplicity.
}