int a = 5;
int b = 8;

// here a is true, no need to evaluate second part, it is short circuited.
if (a == 5 || ++b == 7) {
   System.out.println(a + " " + b);
}
// but here the second part is evaluated and b is incremented.
if (a == 5 | ++b == 7) {
  System.out.println(a + " " + b);
}