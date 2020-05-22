A ref;
B objB = new B(); // calls B's constructor, then A's constructor which prints "In Class A"
C objC = new C(); // calls C's constructor, then A's constructor which prints "In Class A"
ref = objB;
ref.show(); // prints "In Class B"
ref = objC;
ref.show(); // prints "In Class C"