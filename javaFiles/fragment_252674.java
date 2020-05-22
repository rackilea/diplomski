public Scanner(InputStream source) {
  this(new InputStreamReader(source),    
      WHITESPACE_PATTERN);
}

private Scanner(Readable source, Pattern pattern) {
  // ...
  this.source = source;
   // ...
}