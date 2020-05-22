int myReadByte(DataInputStream dis) {
    int b;
    try {
        b = dis.readByte():
    } catch (EOFException e) {
        b = 0;
    }
    return b;
}