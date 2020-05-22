...
    //byte[] to string
    String byte_string = new String(byte_array);

    //String to byte[]
    byte[] string_byte = byte_string.getBytes();

    System.out.println(Arrays.equals(byte_array, string_byte));