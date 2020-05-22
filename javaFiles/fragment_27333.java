StringReader reader = new StringReader("20120101");
    String y, m, d;
    char buffer[];

    buffer = new char[4];
    reader.read(buffer);
    y = new String(buffer);        
    buffer = new char[2];
    reader.read(buffer);
    m = new String(buffer);
    reader.read(buffer);
    d = new String(buffer);