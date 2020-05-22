File file = new File("c:/collection.xml");
    byte[] buf = new byte[(int)file.length()];
    try (InputStream in = new FileInputStream(file)) {
        in.read(buf);
    }
    String s = new String(buf, "ISO-8859-1");