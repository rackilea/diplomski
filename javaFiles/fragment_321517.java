while (t < maxIter && norm < 4) {
    x = (x*x) - (y*y) + r;
    y = (2*x*y) + i;
    norm = (x*x) + (y*y);
    t++;
}