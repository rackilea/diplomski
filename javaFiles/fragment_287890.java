int[] x={1, 2, 5, 7};
int s=0;
for(int i=0; i<x.length; i++) s+=x[i];
double m=s/4.;
double d=0;
for(int i=0; i<x.length; i++) d+=(x[i]-m)*(x[i]-m);
d/=4.;
int s2=0;
for(int i=0; i<x.length; i++) s2+=x[i]*x[i];
double m2=s2/4.;
double d2=m2-m*m;

System.out.println(m+" "+d+" "+d2+" "+m2);