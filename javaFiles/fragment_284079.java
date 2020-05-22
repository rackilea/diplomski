String str = "foo";
    String enc = new sun.misc.BASE64Encoder().encode(str.getBytes(Charsets.UTF_8));
    // enc = enc + "x";
    // enc = enc + "x";
    byte [] decBytes = new sun.misc.BASE64Decoder().decodeBuffer(enc);
    String dec = new String(decBytes, Charsets.UTF_8);
    System.out.println(dec);