//file to byte[] 
    byte[] byte_array = Files.readAllBytes(path);
    byte[] encoded = Base64.encodeBase64(byte_array);

    //byte[] to string
    String byte_string = new String(encoded, StandardCharsets.US_ASCII);

    //String to byte[]
    byte[] string_byte = byte_string.getBytes(StandardCharsets.US_ASCII);
    byte[] decoded = Base64.decodeBase64(string_byte);

    System.out.println(Arrays.equals(byte_array, decoded));