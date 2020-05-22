class Parent {
   Parent(int a){}
}

class Child extends Parent{

   // compiles fine!
   Child() {
      super(42);
   }

}