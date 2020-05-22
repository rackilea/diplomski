//Find number of lines in txt file
  int numLine=0;
  String line = null;
  while ((line = buf.readLine()) != null) {
    numLine++;
  }