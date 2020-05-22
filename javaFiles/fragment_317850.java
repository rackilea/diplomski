// COMPILES FINE!!

class Parent  {

   // method has same name as class, but not a constructor
   int Parent(int a) {
      System.out.println("Yipppee!!!");
      return 42;
   }

   // no explicit constructor, so default constructor is provided
}

class Child extends Parent {

   // no explicit constructor, so default constructor is provided

}