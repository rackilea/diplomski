public static void filesToZip(HttpServletResponse response, File... files) throws IOException {
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        // create the ZIP file
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        // compress the files
        for(int i=0; i<files.length; i++) {
            FileInputStream in = new FileInputStream(files[i].getName());
            // add ZIP entry to output stream
            out.putNextEntry(new ZipEntry(files[i].getName()));
            // transfer bytes from the file to the ZIP file
            int len;
            while((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            // complete the entry
            out.closeEntry();
            in.close();
        }
        // complete the ZIP file
        out.close();
    }