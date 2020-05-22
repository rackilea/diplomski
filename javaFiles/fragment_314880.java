FileInputStream mInStream = new FileInputStream("file path").
byte[] buffer = new byte[1024]; 

    // Keep listening to the InputStream 
    while (true) {
        try {
         bytes = mInStream.read(buffer, 0, buffer.length);
        }catch {} 
    }