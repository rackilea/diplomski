String tempStr = new BASE64Encoder().encode("hi".getBytes());

     byte[] word_bytes = new BASE64Decoder().decodeBuffer(tempStr);

     System.out.println(tempStr);
     System.out.println(new String(word_bytes));