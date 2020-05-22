Test ob1 = new Test(2); // new object Test(2)
Test ob2;  // new memory space reserved for ob2, but ob2 = null

ob2 = ob1.increment();  // ob2 now references to Test(4) object created at increment method

// print statements

ob2 = ob2.increment(); // ob2 is now Test(8)