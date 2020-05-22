FileInputStream fileInputStream = new FileInputStream( "my_image_file_path" );

int nRead;
byte[] data = new byte[16384];

try {
    while( (nRead = fileInputStream.read(data)) != -1 ){
        networkOutputStream.write( data, 0, nRead );
    }

} catch( IOException e ){
    e.printStackTrace();
}
fileInputStream.close();