private enum Operation {
   ADDITION("Add"), SUBTRACTION("Subtract"), MULTIPLICATION("Multiply"), DIVISION("Divide");

   public final String name;

   Operation(String name) {
       this.name = name;      
   }
}