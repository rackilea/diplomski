// TODO: edge cases, error handling, header delimiter, etc.
int byteCount = 0;
int headerIndex = 0;
while (true) {
  String key = httpConnection.getHeaderFieldKey(headerIndex);
  if (key == null)
    break;
  String value = httpConnection.getHeaderField(headerIndex++);
  byteCount += key.getBytes("US-ASCII").length
      + value.getBytes("US-ASCII").length + 2;
}
byteCount += httpConnection.getHeaderFieldInt("Content-Length",
    Integer.MIN_VALUE);