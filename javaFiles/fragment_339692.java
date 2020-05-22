x = 5;  y = 10;
    System.out.println(z = y *= x++); // output is 50 -->z=y=y*x i.e, z=y=10*5 (now, after evaluation of the expression, x is incremented to 6)
    x = 2; y = 3; z = 4;
    System.out.println("Result = "+ z + y++ * x); // output is Result = 46 --> from Right to left . y++ * x happens first..So, 3 * 2 = 6 (now, y will be incremented to 4) then "Result = " +z (String) + number (y++ * z) will be concatenated as Strings.
    x = 5;
    System.out.println( x++*x); // output is 30 --> 5 * (5+1 i.e, x is already incremented to 6 when you do x++ so its like 5 *6 )
    x = 5;
    System.out.println( x*x++); // output is 25 -- > 5 * 5 (x will be incremented now)