ByteArrayOutputStream stream = new ByteArrayOutputStream();
    while(/* condition */ ) { // Get bytes from the file
        // Append bytes to the byteArray
        stream.write(bytes); 
    }

    String str = new String(stream.toByteArray()); // Get the string representation