public int nextByte() {
    int b = nextBoolean() ? 0x80 : 0;

    if (nextBoolean()) b = b | 0x40;
    if (nextBoolean()) b = b | 0x20;
    if (nextBoolean()) b = b | 0x10;
    if (nextBoolean()) b = b | 0x08;
    if (nextBoolean()) b = b | 0x04;
    if (nextBoolean()) b = b | 0x02;
    if (nextBoolean()) b = b | 0x01;

    return b;
}