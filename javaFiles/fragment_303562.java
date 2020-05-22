final Closer closer = Closer.create();
final InputStream in;
final OutputStream out;
final byte[] buf = new byte[32768]; // 32k
int bytesRead;

try {
    in = closer.register(createInputStreamHere());
    out = closer.register(new FileOutputStream(...));
    while ((bytesRead = in.read(buf)) != -1)
        out.write(buf, 0, bytesRead);
    out.flush();
} finally {
    closer.close();
}