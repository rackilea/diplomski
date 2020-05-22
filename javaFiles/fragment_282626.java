public  File zip(List<File> files, String filename) {
    File zipfile = new File(filename);
    FileInputStream in=null;
    ZipOutputStream out=null;
    // Create a buffer for reading the files
    byte[] buf = new byte[1024];
    try {
        // create the ZIP file
        out = new ZipOutputStream(new FileOutputStream(
                zipfile));
        // compress the files
        for (int i = 0; i < files.size(); i++) {

            in = new FileInputStream(files.get(i));

            // add ZIP entry to output stream
            out.putNextEntry(new ZipEntry(files.get(i).getName()));
            // transfer bytes from the file to the ZIP file
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


    } catch (IOException ex) {
        ex.printStackTrace();
    }finally {

        try {
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            out.closeEntry();

            out.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    return zipfile;
}