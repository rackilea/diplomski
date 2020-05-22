void zipping(File file) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("C:\\...\\newZip.zip");
        ZipOutputStream zos = new ZipOutputStream(os);

        File folder = new File("C:\\...\\A");

        for (final File fileEntry : folder.listFiles()) {

            FileInputStream in = new FileInputStream(fileEntry);
            zos.putNextEntry(new ZipEntry(fileEntry.getName()));

            // buffer size
            byte[] b = new byte[1024];
            int count;

            // Read from file and write to zip file
            while ((count = in.read(b)) > 0) {
                zos.write(b, 0, count);
            }
        }    

        zos.close();
    }