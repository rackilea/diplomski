long M = 0;
int hash = 1;
for(int i = toDecrypt.length() - 1 ; i >= 0; i--)
{
    M += (toDecrypt.charAt( i ) - '0') * hash;
    hash *= 10;
}