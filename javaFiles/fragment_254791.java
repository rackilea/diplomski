byte[] bytesRepresentation = {(byte)0x25};
String dataAsString = new String(bytesRepresentation, "IBM-037");
byte[] newBytesRepresentation =
dataAsString.getBytes(Charset.forName("IBM-037"));
System.out.println(byteArrayToHexString(bytesRepresentation));
System.out.println(byteArrayToHexString(newBytesRepresentation));