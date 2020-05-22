class Name {
   void methodOne() {
     class InnerClass {
       void methodTwo() {
       }
     }

     InnerClass x = new InnerClass();
     x.methodTwo();
   }
}