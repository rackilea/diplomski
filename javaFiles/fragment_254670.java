DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

// File Header
out.write(MAGIC); // an 8 byte array (like new byte[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}) to identify the file format
out.writeShort(VERSION); // a short (like 1)

// GZIP that stuff
ByteArrayOutputStream bytes = new ByteArrayOutputStream();
GZIPOutputStream zippedStream =new GZIPOutputStream(bytes)
mapper.writeValue(zippedStream, /* my data */); // mapper is the   Jackson ObjectMapper, my data is a Map<String, Object>


zippedStream.close();

byte[] data = bytes.toByteArray();

out.writeInt(data.length);
out.write(data);

out.close();