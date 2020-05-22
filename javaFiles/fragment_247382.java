class Parent<C extends Parent> {

   public C getMe (){
      return this;
   }
}

class Sub extends Parent<Sub> { }