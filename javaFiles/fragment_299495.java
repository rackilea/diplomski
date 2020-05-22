byte [] buf = new byte [1024];
   int len = is.read(buf);
   while (len > 0){
       fw.write (buf,0,len);
        // more stuff

        // read next chunk
       len = is.read(buf);
    }