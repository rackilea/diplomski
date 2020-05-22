InputStream stream = new URL(key).openStream();
ByteArrayOutputStream out = new ByteArrayOutputStream();
ByteStreams.copy(stream, out);
ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

// use it once
in.reset();
// use it again