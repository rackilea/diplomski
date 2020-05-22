class Main {
   int argCount;

   // constructor
   public Main (String[] args) {
     // and back to boring ol' non-static Java
     argCount = args.length;       
   }

   void runIt () {
      System.out.println("arg count: " + argCount);
   }

   // must be static -- no Main instance created yet
   public static void main (String[] args) {
      Main me = new Main(args);
      me.runIt();
   }
}