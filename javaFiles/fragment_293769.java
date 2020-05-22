void append(String s) {
    if (buffer.length() + s.length() > MAX_LENGTH) {
        buffer.delete(0, buffer.length() + s.length() - MAX_LENGTH);
    }
    buffer.append(s, Math.max(0, s.length() - MAX_LENGTH), s.length());
}