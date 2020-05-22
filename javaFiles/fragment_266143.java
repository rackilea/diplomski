char[] cbuf = new char[10240]; // size of the read buffer
int charsRead = reader.read(cbuf); // read first set of chars
StringBuilder buffer = new StringBuilder(); // accumulate the data read here

while(charsRead > 0) {
    buffer.append(cbuf, 0, charsRead);
    if (charCount > LIMIT) { // define a LIMIT constant with your size limit
        throw new XMLTooLargeException(); // treat the problem with an exception
    }
}
String xmlFileAsString = buffer.toString(); //if not too large, get the string