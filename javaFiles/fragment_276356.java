for(char origChar : message.toCharArray()) {
  if (origChar == ' ') {
    s.append(' '); 
    continue;
  }
  // do other "encryption"