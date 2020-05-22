private static String createDataSize(int msgSize) {
  StringBuilder sb = new StringBuilder(msgSize);
  for (int i=0; i<msgSize; i++) {
    sb.append('a');
  }
  return sb.toString();
}