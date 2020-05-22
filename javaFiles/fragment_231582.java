// This is the obvious part:
Cat c= new Cat();
c.m(); // "CAT"
c.foo(); // "FOO"

// Not so obvious
Animal a2= new Cat(); // a Cat is an animal
a2.m(); // "CAT"
a2.foo(); //Won't compile: ERROR