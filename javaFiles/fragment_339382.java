Test ob1 = new Test(2); // new object Test(2)
Test ob2;  // new memory space reserved for ob2, but ob2 = null

ob2 = ob1.increment();  // ob2 now references to object Test(4) created at increment method

// print statements

Test ob3 = ob2; // Test(4) is now referencing to ob2 and ob3

ob2 = ob2.increment(); // ob2 is now Test(8)