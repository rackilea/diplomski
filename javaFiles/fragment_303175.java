char[] buf;
int charcount = 0;
StringBuilder line = new StringBuilder(2048);
InputStreamReader reader = new InputStreamReader(stream);// provides a line-wise read
BufferedReader file = new BufferedReader(reader);
do { // capture loop
    try {
    buf = new char[2048];
    charcount = file.read(buf, 0, 2048);
    } catch (IOException e) {
    return null; // unknown IO error
    }
    line.append(buf);
} while (charcount != -1);
// close and output