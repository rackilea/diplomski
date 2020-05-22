public byte[] fixPS(ByteArrayOutputStream out) {
    byte[] in = out.toByteArray();

    byte[] comments = "%%EndComments\n".getBytes(StandardCharsets.US_ASCII);
    byte[] skip = "%!PS-Adobe-3.0\n".getBytes(StandardCharsets.US_ASCII);

    byte[] ret = new byte[in.length + comments.length];
    System.arraycopy(skip, 0, ret, 0, skip.length);
    System.arraycopy(comments, 0, ret, skip.length, comments.length);
    System.arraycopy(in, skip.length, ret, skip.length + comments.length, in.length - (skip.length + comments.length));
    return ret;
}