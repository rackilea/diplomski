public byte[] getData() {
       byte[] buffer = nativeGetData(mNativePix);

        if (buffer == null) {
            throw new RuntimeException("native getData failed");
        }
        return buffer;
  }
  private static native byte[] nativeGetData(long nativePix);