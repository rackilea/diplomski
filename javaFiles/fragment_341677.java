for (...) {
    ...
    for (int i = 0; i < splitSize && pos < length; i++) {
        out.write(in.read());
        pos++;
    }
}