String decode(String stringToDecode) {
  int n = stringToDecode.length();
  StringBuilder out = new StringBuilder(n);
  int decoded = 0;
  for (int i = 0; i < n; ++i) {
    switch (stringToDecode.charAt(i)) {
      case '\\':
        out.append(stringToDecode, decoded, i);
        decoded = ++i;
        break;
      case '_':
        out.append(stringToDecode, decoded, i).append(' ');
        decoded = i+1;
        break;
    }
  }
  return decoded != 0
      ? out.append(stringToDecode, decoded, n).toString()
      : stringToDecode;
}