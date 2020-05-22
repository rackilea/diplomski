long sum = 0;
for (int i = 1; i <= e; ++i) {
    if (!((i % 7 == 0) ^ (i % 11 == 0))) {
        sum += i;
    }
}