class X{
   final int i;
   X(){ 
      foo();
      i = 5;
   }

   void foo(){
      assert(i == 5); // Fails, of course
   }
}