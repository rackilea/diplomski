Charset charset = Charset.forName("ISO-8859-1"); // ISO Latin Alphabet No. 1
OutputStream ostream = new ByteArrayOutputStream(); // or other OutputStream
Writer writer = new OutputStreamWriter(ostream, charset);

BeanWriter beanWriter = streamFactory.createWriter(nameOfMappedStream, writer);

// write beans here...

writer.flush();