Thread 1:
r1 = v;
r2 = r1 + 1;
v = r2;

Thread 2:
r3 = v;
r4 = r3 - 1;
v = r4;