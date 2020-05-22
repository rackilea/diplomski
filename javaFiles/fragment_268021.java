int a = 1;
int b = 2;
double c = 0.0;

while (a < 5 && b < 6){
  c=java.lang.Math.pow (a,b);
  System.out.println ( a+ " " +b +" " + c); 
  b++;
  a++;
}