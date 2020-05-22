class Test {
      private void doThis() {};

      public static void main() {  
         Test a = new Test();
         Test b = new Test();

         a.doThis(); // No problem
         b.doThis(); // No problem
      }
   }