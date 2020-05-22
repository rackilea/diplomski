int readBytes = 0;

while ((line = rd.readLine()) != null) {
    readBytes += line.getBytes("ISO-8859-2").length + 2; // CRLF bytes!!
    // Do something with line.
}