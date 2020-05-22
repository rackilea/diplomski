else if(ch == '}') {
  if (currentCharacters.length() > 0) {
    handleText(currentCharacters.toString());
    currentCharacters = new StringBuffer();
  }
  if (level == 0)
    throw new IOException("Too many close-groups in RTF text");
  endgroup();
  level --;
}