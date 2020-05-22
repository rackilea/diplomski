double a = 1.7976931348623155E308;
double old = a;
a++;
System.out.println(a);      // prints 1.7976931348623155E308
System.out.println(old);    // prints 1.7976931348623155E308
System.out.println(a==old); // prints "true"