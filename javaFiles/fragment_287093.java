long[] OutOfBounds = new long[];
OutOfBounds[0] = 100;
// this is an error, it's trying to access something that does not exist.

long[] legit = new long[3];
legit[0] = 0;
legit[1] = 500;
legit[2] = 1000;
// legit[3] = 0; Again, this will give you an error.