SomeClass A = new SomeClass();
    SomeClass B;
    B = A;        // Same class, same object, different reference


A.someMethod(); //uses one object
B.someMethod(); //uses the same object