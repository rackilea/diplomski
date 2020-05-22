try {
    input = new BufferedInputStream(new FileInputStream(source));
    output = new BufferedOutputStream(new FileOutputStream(dest));
    byte[] buffer = new byte[input.available()];
    int read = -1;
    while((read = input.read(buffer)) != -1) {
        byte[] bufferEncoded = buffer;
        if (read != buffer.length) { 
            bufferEncoded = Arrays.copyOf(buffer, read);
        }
        byte[] bufferDecoded = Base64.getDecoder().decode(bufferEncoded);
        output.write(c.update(bufferDecoded));
    }
    output.write(c.doFinal()); 
}