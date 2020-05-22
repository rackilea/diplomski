class Foo {

   static final boolean ABC = true;

   public void someMehod() {
       if (ABC) {  // #ifdef ABC

       } else {    // #else

       }           // #endif
   } 
}