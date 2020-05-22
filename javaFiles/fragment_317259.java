int x = 3;
{
   int x = 13; // error!
}

Consumer<Integer> consumer = (x)->print(x);  // ERROR! 
// lambda parameter is treated like local variable

Runnable r = ()->{ int x; ... } // ERROR
// lambda body is treated like local block