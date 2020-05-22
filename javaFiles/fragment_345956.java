int aMid = 0;
int bMid = k - aMid - 1;
if(bMid >= bLen) {
    bMid = bLen - 1;
    aMid = k - bMid - 1;
}