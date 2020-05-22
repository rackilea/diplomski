method1Caller(){
   a1 ---> "s"
   method(a1) // copies a1 reference
 }

 method(a1){ //a1 points to "s" at this point
 a = a + "xyz"; //changing reference
 a ---> "sxyz"
 method2(a); // copies a which reference "sxyz"
 }