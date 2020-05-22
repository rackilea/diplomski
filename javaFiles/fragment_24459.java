C a2 = new C();
C a1 = new C();
C a3 = new C();

a1.i = a3.i; // => a3.i = 0 then a1.i = 0;
a2 = a1; // => a1 and a2 are the same objects (point to the same references)
a2.i = 12; //=> a2.i = 12, so a1.i = 12
a3.i = a3.i + 1;// => a3.i = 1
a1.i = 9; // => a1.i = 9 so a2.i = 9
a1.k = 11; // => a1.k = 11 so a2.k = 11
a2.k = 12; // => a2.k = 12 so a1.k = 12
//a1.i = 9 / a2.i = 9 / a3.i = 1 / a1.k = 12 / a2.k = 12
System.out.println(a1.i + " " + a2.i + " " + a3.i + " " + a1.k + " " + a2.k);