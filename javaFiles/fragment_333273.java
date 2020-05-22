BufferedInputStream bin = new BufferedInputStream(fin);  

    BufferedOutputStream bout = new BufferedOutputStream(out);  
    int ch =0; ;  

    sun.misc.BASE64Encoder encoder= new sun.misc.BASE64Encoder();
    byte[] contents = new byte[5000000];
    int bytesRead = 0;
    String strFileContents;
    while ((bytesRead = bin.read(contents)) != -1) {
        bout.write(encoder.encode(contents).getBytes());
    }
    bout.close();
    fin.close();
    bin.close();
    out.close();