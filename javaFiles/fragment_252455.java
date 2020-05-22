InputStream inputStream = file.getContents();

StringWriter writer = new StringWriter();

// Copy to string, use the file's encoding
IOUtils.copy(inputStream, writer, file.getCharset());

// Done with input
inputStream.close();

String theString = writer.toString();

theString = theString + " added";

// Get bytes using the file's encoding
byte[] bytes = theString.getBytes(file.getCharset());

InputStream source = new ByteArrayInputStream(bytes);

file.setContents(source, IResource.FORCE, null);