public double discrim (double a, double b, double c)
{ 
  return (b*b)-(4*a*c);
}


public int numRoots (double a, double b, double c)
{ 
double d = discrim (a,b,c);
if (d>0)
 return 2;
else if (d<0)
 return 0;
else
 return 1;
}