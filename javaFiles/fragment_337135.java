System.out.println(   3 + 4 + "X"     ); // prints "7X"
System.out.println(   3 + (4 + "X")   ); // prints "34X"
System.out.println(   "X" + 3 + 4     ); // prints "X34"
System.out.println(   "X" + (3 + 4)   ); // prints "X7"

System.out.println(0 == 0);                           // prints "true"
System.out.println(new Integer(0) == new Integer(0)); // prints "false"

System.out.println(true & (1 & 2) == 12); // prints "false"