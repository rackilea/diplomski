Rectangle x = new Square(10);
Rectangle y = new Rectangle(5,6);

// assume that x and y aren't changed 

x.aaa();   // runs the overriding method aaa in Square
y.aaa();   // runs the method aaa in Rectangle

x.bbb();   // runs the method in Rectangle, since it's not overridden.  But
           // if bbb calls aaa, then it will call the aaa in Square.
y.bbb();   // runs the method in Rectangle

x.ccc();   // illegal.  Even though the object is actually a Square, the
           // compiler isn't allowed to know that.
y.ccc();   // illegal

((Square)x).ccc();  // This is how you can get to the new method that you
           // declared in Square.  Even though the compiler doesn't know 
           // that x is a Square, when you use the cast, you tell the 
           // compiler that it's OK fo treat it as a Square, and to access
           // the method defined only in Square.
((Square)y).ccc();  // Will throw ClassCastException at runtime, because 
           // y isn't a Square.