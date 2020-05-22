int c1 = (a1 + a2) ^ a2;
int c2 = (b1 - b2) << 4;

int tmp0 = c1;
int tmp1 = 0;
int tmp2 = 0;
int tmp3 = 0;

int z0 = 0;
int z1 = 1;
int z2 = 2;
int z3 = 3;

do{
    tmp0 ^= z0 + c2;
    tmp1 ^= z1 + c2;
    tmp2 ^= z2 + c2;
    tmp3 ^= z3 + c2;
    z0 += 4;
    z1 += 4;
    z2 += 4;
    z3 += 4;
}while (z0 < 100);

tmp0 ^= tmp1;
tmp2 ^= tmp3;

tmp0 ^= tmp2;

return tmp0;