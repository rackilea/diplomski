// Step 1: read all the bytes
final ByteArrayOutputStream out = new ByteArrayOutputStream();
final byte[] buffer = new byte[8196];

int count;

while ((count = in.read(buffer)) != -1)
    out.write(buf, 0, count);

// Step 2: wrap the array
final ByteBuffer byteBuffer = ByteBuffer.wrap(out.toByteArray());

// Step 3: decode
final CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder()
    .onUnmappableCharacter(CodingErrorAction.REPORT)
    .onMalformedInput(CodingErrorAction.REPORT);

final CharBuffer charBuffer = decoder.decode(byteBuffer);

charBuffer.flip();
return charBuffer.toString();