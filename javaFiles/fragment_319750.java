if(array==null || array.length == 0)
  System.out.println("NO SOLUTION");

double s=0;
for(int x: array)
  s+=x;

int avg = (int)(s/array.length);


if(avg == s/array.length)
    System.out.println(avg);
else
    System.out.println("NO SOLUTION");