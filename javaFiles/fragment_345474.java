CharBuffer yourCharBuffer = CharBuffer.wrap("Roland");

    ByteBuffer result = ByteBuffer.allocate(yourCharBuffer.length() * Character.BYTES);
    CharBuffer converter = result.asCharBuffer();
    converter.append(yourCharBuffer);

    System.out.println(Arrays.toString(result.array()));