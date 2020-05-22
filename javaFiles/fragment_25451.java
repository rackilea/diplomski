@Override public void require(long byteCount) throws IOException {
    if (!request(byteCount)) throw new EOFException();
  }

  @Override public boolean request(long byteCount) throws IOException {
    if (byteCount < 0) throw new IllegalArgumentException("byteCount < 0: " + byteCount);
    if (closed) throw new IllegalStateException("closed");
    while (buffer.size < byteCount) {
      if (source.read(buffer, Segment.SIZE) == -1) return false;
    }
    return true;
  }