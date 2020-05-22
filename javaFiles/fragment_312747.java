int modulo(int n, int p)
{
int r = n%p;
    if(((p > 0) && (r < 0)) || ((p < 0) && (r > 0)))
        r += p;
    return r;
}