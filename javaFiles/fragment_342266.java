try
{
    FileInputStream fileInputStream  = new FileInputStream(file);
    byte[] buf=new byte[8192];
    int bytesread = 0, bytesBuffered = 0;
    while( (bytesread = fileInputStream.read( buf )) > -1 ) {
        out.write( buf, 0, bytesread );
        bytesBuffered += bytesread;
        if (bytesBuffered > 1024 * 1024) { //flush after 1MB
            bytesBuffered = 0;
            out.flush();
        }
    }
}
finally {
    if (out != null) {
        out.flush();
    }
}