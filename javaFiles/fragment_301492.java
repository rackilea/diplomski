double mth = val;

for (int i = 0, s = 3; i < 16; i++, s = s + 2) {
    mth = mth * val * val;
    mth = mth / ((s - 1) * s);
    memory.add(mth);
}