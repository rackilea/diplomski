public static void main(String[] args) throws IOException {
    ZipFile zipFile = new ZipFile("/home/*********/resources/dice.zip");
//        ZipFile zipFile = new ZipFile();
    final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("diceUp.zip"));
    for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements(); ) {
        ZipEntry entryIn = e.nextElement();
        if (entryIn.getName().contains(".png")) {
            System.out.println(entryIn.getName());
            ZipEntry zipEntry = new ZipEntry(entryIn.getName());
            zos.putNextEntry(zipEntry);
            InputStream is = zipFile.getInputStream(entryIn);
            byte[] buf = new byte[1024];
            int len;
            while ((len = (is.read(buf))) > 0) {
//                    zos.write(buf, 0, (len < buf.length) ? len : buf.length);
                zos.write(buf);
            }
        }
        zos.closeEntry();
    }
    zos.close();
}