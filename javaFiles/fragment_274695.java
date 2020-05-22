StringBuilder sb= new StringBuilder();
    try (InputStream inst = new BufferedInputStream(new FileInputStream("c:/collection.xml"))) {
        for(int i; (i = inst.read()) != -1;) {
            sb.append((char)i);
        }
    }
    String s = sb.toString();