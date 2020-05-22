Socket s = servsock.accept();

    InputStream in = s.getInputStream();
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("YOUR_FILE"));

    int c=0;
    byte[] buff=new byte[2048];

    while((c=in.read(buff))>0){ // read something from inputstream into buffer
        // if something was read 
        bos.write(buff, 0, c);
    }

    in.close();
    bos.close();