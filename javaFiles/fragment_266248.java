// Load in the data file in read-only mode:
RandomAccessFile randFile = new RandomAccessFile("inputFileName.txt", "r");

// (On your own): Calculate starting byte to read from
// (On your own): Calculate ending byte to read from

// Discard header and footer.
randFile.setLength(endingPoint);
randFile.seek(startingPoint);

// Discard newlines of any kind as they are read in.
StringBuilder sb = new StringBuilder(endingPoint - startingPoint);
String currentLine = "";
while(currentLine != null)
{
  sb.append(currentLine);
  currentLine = randFile.readLine();
}

// hash your String contained in your StringBuilder without worrying about
// header, footer or newlines of any kind.