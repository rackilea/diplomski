public class unpackZip {
    public boolean unzip(String zipname, String path) {
        InputStream is;
        ZipInputStream zis;
        try {
            String filename;
            is = new FileInputStream(zipname);
            zis = new ZipInputStream(new BufferedInputStream(is));
            ZipEntry ze;
            byte[] buffer = new byte[1024];
            int count;

            while ((ze = zis.getNextEntry()) != null) {
                // zapis do souboru
                filename = ze.getName();

                // Need to create directories if not exists, or
                // it will generate an Exception...
                if (ze.isDirectory()) {
                    File fmd = new File(path, filename);
                    fmd.mkdirs();
                    continue;
                } else {
                    // Make this part of the code more efficient .code-revise
                    File fmd = new File(path, filename);
                    Log.d("Unzipping", fmd.getParentFile().getPath());
                    String parent = fmd.getParentFile().getPath();

                    File fmd_1 = new File(parent);
                    fmd_1.mkdirs();
                    // end of .code-revise
                }

                FileOutputStream fout = new FileOutputStream(path + filename);

                // cteni zipu a zapis
                while ((count = zis.read(buffer)) != -1) {
                    fout.write(buffer, 0, count);
                }

                fout.close();
                zis.closeEntry();
            }

            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}