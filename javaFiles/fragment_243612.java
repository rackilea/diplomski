int topIdx1 = 0, topIdx2 = 0;
for (int i = 1; i < 6; i++)
    if (count[i] > count[topIdx1]) {
        topIdx2 = topIdx1;
        topIdx1 = i;
    } else if (count[i] > count[topIdx2]) {
        topIdx2 = i;
    }