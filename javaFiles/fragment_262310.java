long pow = 1;
long square = k;
int exp = n - 1;
while (exp > 0)
{
    if ((exp & 1) == 1)
    {
        pow = (pow * square) % n;
    }
    square = (square * square) % n;
    exp >>= 1;
}