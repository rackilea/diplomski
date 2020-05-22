String inputString = "blahblahblah";
byte[] input = inputString.getBytes("UTF-8");

// Compress the bytes
byte[] output = new byte[100];
Deflater compresser = new Deflater();
compresser.setInput(input);
compresser.finish();
int compressedDataLength = compresser.deflate(output);
compresser.end();
System.out.println(Base64.getEncoder().encodeToString(output));