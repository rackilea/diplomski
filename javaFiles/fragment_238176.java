//byte[] to string
    String byte_string = new String(byte_array, StandardCharsets.ISO_8859_1);

    //String to byte[]
    byte[] string_byte = byte_string.getBytes(StandardCharsets.ISO_8859_1);

    System.out.println(Arrays.equals(byte_array, string_byte));