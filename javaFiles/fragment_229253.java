double circum = 40075 * Math.pow(10, 3); // convert km to m

double f = 9.807; //more accurate

double G = 6.67408e-11;

double r = circum/(2*Math.PI);

double m = f*Math.pow(r, 2)/G;

double e = (Math.sqrt((2.0*G*(m))/r));

System.out.println("The radius is: " + r * Math.pow(10, -3) + " kilometers.");
System.out.println("The mass is: " + m + " kg.");
System.out.println("The escape velocity is: " + e + " m/s.");