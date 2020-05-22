public static void main(String[] args) throws IOException {
    File infile  = new File("test_file.pdf");
    File outfile = new File("test.zip");
    try (FileInputStream  fis = new FileInputStream(infile);
         FileOutputStream fos = new FileOutputStream(outfile);
         ZipOutputStream  zos = new ZipOutputStream(fos) ) {

        byte[]  buffer = new byte[1024];
        ZipEntry entry = new ZipEntry("data");
        precalc(entry, fis.getChannel());
        zos.putNextEntry(entry);
        for(int bytesRead; (bytesRead = fis.read(buffer)) >= 0; )
            zos.write(buffer, 0, bytesRead);
        zos.closeEntry();
    }

    try(FileInputStream fin = new FileInputStream(outfile);
        ZipInputStream  zis = new ZipInputStream(fin) ) {

        ZipEntry entry = zis.getNextEntry();
        System.out.println("Entry size: " + entry.getSize());
        System.out.println("Compressed size: " + entry.getCompressedSize());
        System.out.println("CRC: " + entry.getCrc());
        zis.closeEntry();
    }
}

private static void precalc(ZipEntry entry, FileChannel fch) throws IOException {
    long uncompressed = fch.size();
    int method = entry.getMethod();
    CRC32 crc = new CRC32();
    Deflater def;
    byte[] drain;
    if(method != ZipEntry.STORED) {
        def   = new Deflater(Deflater.DEFAULT_COMPRESSION, true);
        drain = new byte[1024];
    }
    else {
        def   = null;
        drain = null;
    }
    ByteBuffer buf = ByteBuffer.allocate((int)Math.min(uncompressed, 4096));
    for(int bytesRead; (bytesRead = fch.read(buf)) != -1; buf.clear()) {
        crc.update(buf.array(), buf.arrayOffset(), bytesRead);
        if(def!=null) {
            def.setInput(buf.array(), buf.arrayOffset(), bytesRead);
            while(!def.needsInput()) def.deflate(drain, 0, drain.length);
        }
    }
    entry.setSize(uncompressed);
    if(def!=null) {
        def.finish();
        while(!def.finished()) def.deflate(drain, 0, drain.length);
        entry.setCompressedSize(def.getBytesWritten());
    }
    entry.setCrc(crc.getValue());
    fch.position(0);
}