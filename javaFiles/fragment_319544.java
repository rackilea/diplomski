class A {
     A a = new A(); // Recursion
}

class A {
     A() {
         A a = new A(); // Recursion
     }
}

class A {
     A getNewA() {
         return new A();
         // This is fine as it doesn't happen during creation of an A
     }
}

class A {
     A() {
         getNewA(); 
         // Recursion as calling getNewA creates a new A, which calls getNewA, which....
     }

     A getNewA() {
         return new A(); 
         // This is fine on its own but is broken if called from the constructor
     }
}

class B {
     A a = new A(); 
     // This is fine as B is not A, so you can create a new A within B.
}