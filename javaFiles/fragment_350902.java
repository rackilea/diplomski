int s1, s2, s3, s4, s5;
s1 = 75;
s2 = 32;
s3 = 42;
s4 = 99;
s5 = 100;

int min = s1;
min = (min < s2) ? min : s2;
min = (min < s3) ? min : s3;
min = (min < s4) ? min : s4;
min = (min < s5) ? min : s5;
System.out.println(min);