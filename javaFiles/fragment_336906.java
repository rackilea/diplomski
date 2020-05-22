StringWriter response = new StringWriter();
PrintWriter writer = new PrintWriter(response);

char[] buf = new char[4096];
int readChars;
do {
   readChars = inputStreamReader.read(buf);
   writer.write(buf, 0, readChars);
} while(readChars != -1);