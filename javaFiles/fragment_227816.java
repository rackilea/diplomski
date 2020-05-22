// Initialize the streams.
    final FileOutputStream fileOutputStream = new FileOutputStream(file);
    final InputStream inputStream = socket.getInputStream();

    // Header end flag.
    boolean headerEnded = false;

    byte[] bytes = new byte[2048];
    int length;
    while ((length = inputStream.read(bytes)) != -1) {
        // If the end of the header had already been reached, write the bytes to the file as normal.
        if (headerEnded)
            fileOutputStream.write(bytes, 0, length);

        // This locates the end of the header by comparing the current byte as well as the next 3 bytes
        // with the HTTP header end "\r\n\r\n" (which in integer representation would be 13 10 13 10).
        // If the end of the header is reached, the flag is set to true and the remaining data in the
        // currently buffered byte array is written into the file.
        else {
            for (int i = 0; i < 2045; i++) {
                if (bytes[i] == 13 && bytes[i + 1] == 10 && bytes[i + 2] == 13 && bytes[i + 3] == 10) {
                    headerEnded = true;
                    fileOutputStream.write(bytes, i+4 , 2048-i-4);
                    break;
                }
            }
        }
    }
    inputStream.close();
    fileOutputStream.close();