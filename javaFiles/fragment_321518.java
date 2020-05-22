while (t < maxIter && norm < 4) {
    tempx = (x*x) - (y*y) + r;
    y = (2*x*y) + i;
    x = tempx;
    norm = (x*x) + (y*y);
    t++;
}