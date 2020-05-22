String hello = "Hello", 
String lo = "lo";

System.out.print((hello == "Hello") + " ");          // true
System.out.print((Other.hello == hello) + " ");      // true
System.out.print((other.Other.hello == hello) + " ");// true
System.out.print((hello == ("Hel" + "lo")) + " ");     // true
System.out.print((hello == ("Hel" + lo)) + " ");       // false
System.out.println(hello == ("Hel" + lo).intern());    // true