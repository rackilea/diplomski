try (InputStream ins = new BufferedInputStream(sock.getInputStream())) {
    int byteRead;
    while ((byteRead = ins.read()) != -1) {
        System.out.printf("%02X%n", byteRead & 0xFF);
    }
} // Closes