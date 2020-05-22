Manifest m = new Manifest();
String longManifest = "Manifest-Version: 1.0\r\n" +
    "Too-Long: This line is longer than 72 characters, does the Manifest class correctly \r\n" +
    " handle parsing of it even over multiple lines?\r\n";
m.read(new ByteArrayInputStream(longManifest.getBytes(UTF_8)));
System.out.println(m.getMainAttributes().getValue("Too-Long"));