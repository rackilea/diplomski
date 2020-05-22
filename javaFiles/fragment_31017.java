double tc = 23; // just an example
double rh = 67; // just an example
double rh2 = 1 - (0.01 * rh);
double tdc = tc - (14.55 + 0.114 * tc) * rh2 -
        Math.pow((2.5 + 0.007 * tc) * rh2, 3) -
        (15.9 + 0.117 * tc) * Math.pow(rh2, 14);