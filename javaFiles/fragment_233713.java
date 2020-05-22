int inc(int val)     // pass by value
 {
     return ++val;    // increment the passed value and return as a result.
 }

 int incref(int& val) // pass by reference
 {
     return ++val;    // increment the reference.
                      // Since the reference is an alias this increment affects the
                      // original object. The result is returned.
 }

 void code()
 {
       int x = 5;
       int y = inc(x);  // x =5 and y = 6

       int a = 8;
       int b = incref(a); // a = 9 and b = 9
 }