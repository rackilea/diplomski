// Do this once...
int minValueInclusive = -15;
long presence = 0;
for (int value : array) {
    presence |= 1L << (value - minValueInclusive);
}