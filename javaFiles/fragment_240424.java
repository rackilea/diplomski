int tmp;

if (a > b) { tmp = a; a = b; b = tmp; }
if (a > c) { tmp = a; a = c; c = tmp; }
if (b > c) { tmp = b; b = c; c = tmp; }

System.out.println(a + " " + b + " " + c);