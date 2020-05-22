// To perform int result = x >>> 5;
int x = -10;

uint u = unchecked ((uint) x);
u = u >> 5;

int result = unchecked ((int) u);