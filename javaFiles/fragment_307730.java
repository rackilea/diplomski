double x = 0.59999;
double r = 0.25; // Quarters
x = Math.round(x/r)*r;
System.out.println(x); // Result is 0.5

double x = 0.59999;
double r = 0.1; // Tenths
x = Math.round(x/r)*r;
System.out.println(x); // Result is approximately 0.6

double x = 0.31421;
double r = 0.125; // Eighths
x = Math.round(x/r)*r;
System.out.println(x); // Result is exactly 0.375