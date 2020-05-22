int a = 1;
int b = 1;
Integer c = 1;
Integer d = 1;

a.equals(b); // doesnt work as equals isn't define on int
c.equals(b); // work, c is an Integer/Object and b is autoboxed
c.equals(d); // work, both are Integer/Object