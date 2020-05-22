Integer y = 567; // y=567
    Integer x = y;   // x is equal to y object
    System.out.println(x + " " + y); // out put x and y so obviously x and y are 567
    System.out.println(y == x); // here x and y are in same reference. so this x==y is true and out put is true. 
    y++; // increment y by 1. then y=568
    System.out.println(x + " " + y); // now x= 567 and y= 568
    System.out.println(y == x);// now x not equals to y then false will print
    y--; // again decrement y value
    System.out.println(x + " " + y); // again x and y are same 567
    System.out.println(y == x);// here y.value == x.value but x and y object wise not equal since object x and y are referring deference points