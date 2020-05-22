class Parent {
   public Parent(String parentName) {}
}

class Child extends Parent {
   public Child(String name) {
      // must call parent constructor. unlike normal method
      super(name);
      // do some other fancy stuffs here
   }
}