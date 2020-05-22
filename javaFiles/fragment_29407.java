@Override
  public void write(DataOutput out) throws IOException {
    long[] longs = set.toLongArray();
    out.writeInt(longs.length);
    for (int i = 0; i < longs.length; i++) {
      out.writeLong(longs[i]);
    }
  }

  @Override
  public void readFields(DataInput in) throws IOException {
    long[] longs = new long[in.readInt()];
    for (int i = 0; i < longs.length; i++) {
      longs[i] = in.readLong();
    }

    set = BitSet.valueOf(longs);
  }