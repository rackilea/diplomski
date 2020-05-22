int m (int x) {     // x is a local (parameter) variable
   int a;           // a is a local variable as well
   a = x;
   if (x < 10) {
     m(x + 1);
   }
   return a;
}

// If local variables DO maintain state in the object, and therefor
// across methods calls, this would print 10 as the "last"
// `a = x` line executed is the innermost call, when x = 10.
// (Spoiler: it doesn't print 10..)
System.out.println("A: " + m(7));

// Exercise: modify the above such that `a` is a *member variable*
// aka a *field*. How does the result change?