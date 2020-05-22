String test = "Hello world";
byte[] bytes = test.getBytes(StandardCharsets.UTF_8);
System.out.println("MD5 checksum for file using Java : " 
    + checkSum(new ByteArrayInputStream(bytes)));
System.out.println("MD5 checksum for file using Java : " 
    + checkSum(new ByteArrayInputStream(bytes)));