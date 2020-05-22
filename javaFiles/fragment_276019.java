private StringBuilder readStringHelper() throws IOException {
  StringBuilder readStringBuilder = new StringBuilder(128);
    final int l = readInt();
    if (l <= 0) {
        switch (l) {
            case -1: return null;
            case 0: break;
            default: throw new IOException("invalid string length encoding: " + l);
        }
    }
    for (int i=0; i<l; ++i) {
        readStringBuilder.append(readChar());
    }
    return readStringBuilder;
}

@Override
public String readString() throws IOException {
    StringBuilder readStringBuilder = readStringHelper();
    return readStringBuilder==null ? null : readStringBuilder.toString();
}

@Override
public String readString(final StringCache cache) throws IOException {
    StringBuilder readStringBuilder = readStringHelper();
    return readStringBuilder== null ? null : cache.get(readStringBuilder, readStringBuilder);
}