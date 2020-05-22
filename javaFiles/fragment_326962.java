try {
    InputStream inputStream = FileIO.class.getResourceAsStream(path);
    BufferedInputStream in = new BufferedInputStream( inputStream );

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] bytes = new byte[ 1024 ];
    for( int length; ( length = ins.read( bytes ) ) != -1; )
       bos.write( bytes, 0, length );
    }
inputStream.close();
return bos;