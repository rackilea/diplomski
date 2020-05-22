public void zipper(String[] filenames, String zipfile){
        byte[] buf = new byte[2048];
        try {
            String outFilename = zipfile;
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
            for (int i=0; i<filenames.length; i++) {
                FileInputStream in = new FileInputStream(filenames[i]);
                File file = new File(filenames[i]);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (IOException e) {
        }

    }