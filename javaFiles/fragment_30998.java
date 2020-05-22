byte b;
int s;

void WriteBit(bool x)
{
    b |= (x ? 1 : 0) << s;
    s++;

    if (s == 8)
    {
        WriteByte(b);
        b = 0;
        s = 0;
    }
}