ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(archiveName));

try {
    for (String s : dir.list()) {
        File toCompress = new File(dir, s);
        FileInputStream fis = new FileInputStream(toCompress);

        try {
            zos.putNextEntry(new ZipEntry(s));
            int len;

            while((len = fis.read(buf))>0){
                zos.write(buf, 0, len);
            }
            zos.closeEntry();

        } finally {
            fis.close();
        }
    }
} finally {
    zos.close();
}