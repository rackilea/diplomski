for (int n = 0; n < size; ++n) {
    Pointer p = attachments.get(n).getPointer();
    Pointer q = array[n].getPointer();
    for (int b = 0; b < bytes; ++b) {
        q.setByte(b, p.getByte(b));
    }
}