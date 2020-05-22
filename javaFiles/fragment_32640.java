byte[] buffer = new byte[0x1000];
    int read;
    while( (read=in.read(buffer)) != -1 ) {
        System.out.println("Read "+read +" bytes from socket ("+
               in.available()+" available now)");
    }