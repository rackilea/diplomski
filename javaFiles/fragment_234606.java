public void unzipFile(String zipFile, String outputFolder){
    try {
        byte[] buffer = new byte[1024];

        File folder = new File(outputFolder);
        if(!folder.exists()){
            folder.mkdir();
           }

        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry ze = zis.getNextEntry();

        while(ze!=null){
            String fileName = ze.getName();
            File newFile = new File(outputFolder + File.separator + fileName);

            //create all non exists folders
            //else you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);             

            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            fos.close();
            newFile.setLastModified(ze.getTime());
            ze = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}