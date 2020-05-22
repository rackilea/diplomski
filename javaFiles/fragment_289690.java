public int nextByte() {
    return
        (nextBoolean() ? 0x80 : 0)
        | (nextBoolean() ? 0x40 : 0)
        | (nextBoolean() ? 0x20 : 0)
        | (nextBoolean() ? 0x10 : 0)
        | (nextBoolean() ? 0x08 : 0)
        | (nextBoolean() ? 0x04 : 0)
        | (nextBoolean() ? 0x02 : 0)
        | (nextBoolean() ? 0x01 : 0);
}