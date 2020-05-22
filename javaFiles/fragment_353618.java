long a2 = a & 0xFFFFFFFFL;
long b2 = b & 0xFFFFFFFFL;
checkArgument(b2 > 0);
double dFactor = (double) a2 / b2;
shift = 0;
while (dFactor < 1L<<32) {
   dFactor *= 2;
   shift++;
}
factor = (long) dFactor;