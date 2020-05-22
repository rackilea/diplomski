for (int n = 0; n < size; ++n) {
    Pointer p = attachments.get(n).getPointer();
    for (int b = 0; b < bytes; ++b) {
        mem.setByte(n * bytes + b, p.getByte(b));
    }
}