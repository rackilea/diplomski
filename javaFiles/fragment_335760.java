class Superclass {
   public static void getClassName()
   {
       System.out.println("Superclass static method called");
   }
}
class Subclass extends Superclass {
   public static void getClassName(){
       System.out.println("Subclass ");
   }
   public static void main( String args[]) {
       /* Reference is of Superclass type and object is
        * Subclass type
        */
       Superclass obj = new Subclass();
       /* Reference is of Superclass type and object is
        * of Subclass type.
        */
       Superclass obj2 = new Superclass();
       obj.getClassName();
       obj2.getClassName();
   }
}

//The output will be
Superclass static method called
Superclass static method called