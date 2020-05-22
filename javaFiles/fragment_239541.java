int [] a = new int[5];
a[0] = 2;
a[1] = 5;
a[2] = 1;
a[3] = 6;
a[4] = 0;
println(a.length); // prints 5
int [] temp = new int[3];
System.arraycopy(a,0,temp,0,temp.length);
a = temp;
temp = null;
println(a.length); //prints 3