// have your data 
byte[] data = "{\"name\":\"Camilo\",\"functionName\":\"hello\"}".getBytes();
// open the stream
InputStream inputStream = new ByteArrayInputStream(data);
...
// do something with the inputStream, and reset if you need the same data again
if(inputStream.markSupported()) {
    inputStream.reset();
} else {
    inputStream.close();
    inputStream = new ByteArrayInputStream(data);
}
...
// close the stream after use
inputStream.close();