class Parent {
   Parent(int a){}
}

class Child extends Parent{

   // DOES NOT COMPILE!!
   // Implicit super constructor parent() is undefined for default constructor.
   // Must define an explicit constructor

}