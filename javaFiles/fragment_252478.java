boolean[] bools = /*allocated elsewhere, max. length: 32*/;

int bits = 0;
for (int i = 0; i < bools.length; i++)
    if (bools[i])
        bits |= 1 << i;