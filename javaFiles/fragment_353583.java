class A {
   int i;

   void print() {
      System.out.println("i = " + i);
   }
}

class B extends A {
   int j;
   int i;

   void display() {
      i = j + 1;
      super.i = 1000;
      System.out.println(j + " " + i);
      print(); // this will print the i in A
   }
}