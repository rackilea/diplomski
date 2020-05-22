String mockinput = "3\r\n3\r\n3";
ByteArrayInputStream in = new ByteArrayInputStream(mockinput.getBytes());
// Set up mock user input stream
System.setIn(in);

// Initialize the TriTyp.main(input) method
String[] mainin = {};
TriTyp.main(mainin);