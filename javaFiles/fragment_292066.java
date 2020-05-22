class MyClass {

    int data;
    // attribute of type MyClass, this can represent a hierarchical structure
    // in real life applications.
    MyClass var;

   // this is not a class method, but its constructor, used to create instances
   // of this class, i.e.: MyClass c = new MyClass();
   public MyClass() {
   }

   // this is another constructor, which receives a parameter for setting its
   // attribute data, i.e.: MyClass c = new MyClass(3);
   public MyClass(int data) {
       this.data = data;
   }
}