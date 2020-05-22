class Box<T extends Parent> {

   void test() { T.doSomething(); }

   public static void main(String...args) {
      Box<Parent> parentBox = new Box<>();
      Box<Child> childBox = new Box<>();

      parentBox.test();
      childBox.test();
   }
}