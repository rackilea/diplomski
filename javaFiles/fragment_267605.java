long currPointer = 0;
while(currPointer < raf.length()) {
  long currPointer = raf.getFilePointer(); // save current cursor position
  char currentChar = raf.readChar(); // read current char

  if (currentChar == letter) { // if char equals that to be replaced
     raf.seek(currPointer); // step cursor one step back
     raf.writeChar(ch); // replace char
  }

  currPointer = raf.getFilePointer() // store the position of the cursor 

}