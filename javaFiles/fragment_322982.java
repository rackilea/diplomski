new GZipOutputStream(new ByteArrayOutputStream());

// creates an outputstreams that compress data received and send it to the other stream
// the BAOS then writes the received bytes to memory


new GZipOutputStream(new FileOutputStream());
// it's the same but sending compressed bytes to a file.