private String str = "";
private int pos = 0;

public int read(char[] cbuf, int off, int len) throws IOException {
  if (pos == str.length()) {
    // No leftovers from a previous call available, need to actully read more
    int result = in.read(cbuf, off, len);
    if( result <= 0 ){
      return -1;
    }
    str = new String(cbuf, off, result);
    str = someStringTranformationMethod(str);
    pos = 0;
  }

  // Return as much as we have available, but not more than len
  int available = Math.min(str.length() - pos, len);     
  str.getChars(pos, pos + available, cbuf, off);
  pos += available;
  return available;
}