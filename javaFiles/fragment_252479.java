int bits = /*assigned elsewhere*/;

boolean[] bools = new boolean[30]; /*max. length: 32*/
for (int i = 0; i < bools.length; i++)
    if ((bits & 1 << i) != 0)
        bools[i] = true;