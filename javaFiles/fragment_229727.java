public static byte[] createZipFile(String [][] files) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ZipOutputStream zipfile = new ZipOutputStream(bos);
        byte[] buf = new byte[1024];        
        String fileName = null;     
        int i = 0;
        try {
            while (i < files.length) {

                String [] singleFile = files[i];                    
                fileName = singleFile[0];
                File f = new File(fileName);                
                if (f.exists())
                {
                    FileInputStream in = new FileInputStream(fileName);                                
                    zipfile.putNextEntry(new ZipEntry(i + "_" + singleFile[1]));
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        zipfile.write(buf, 0, len);
                    }
                    in.close();
                }
                i++;
            }
            zipfile.close();
        } catch (IOException e) { }
        return bos.toByteArray();
    }