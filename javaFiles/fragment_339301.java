int x = 3, y = 7, z = 4;

x (3) += x++ (3) * x++ (4) * x++ (5);  // gives x = 63
System.out.println(x);

y = y (7) * y++ (7);
System.out.println(y); // gives y = 49

z = z++ (4) + z (5);
System.out.println(z);  // gives z = 9