double x1, x2, x3, y1, y2, y3;
...
double dotAB = (x1 - x3) * (x2 - x3) + (y1 - y3) * (y2 - y3); // (A - C) * (B - C)
double dotBC = ... // ditto for (B - A) * (C - A)
double dotAC = ... // ditto for (A - B) * (C - B)
if(dotAB * dotBC * dotAC < 0){ OR if(dotAB < 0 || dotBC < 0 || dotAC < 0){
    // do obtuse processing
}