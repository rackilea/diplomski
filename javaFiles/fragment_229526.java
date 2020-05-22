public static void extractAllEntries(String urlPath, String destination) {
    try {
        byte[] buffer = new byte[1024];
        InputStream input = new URL(urlPath).openStream();
        JarInputStream jin = new JarInputStream(input);
        ZipEntry entry;

        while ((entry = jin.getNextEntry()) != null) {
            ZipEntry file = (ZipEntry) entry;
            File f = new java.io.File(destination + java.io.File.separator
                    + file.getName());
            if (file.isDirectory()) {
                f.mkdir();
                continue;
            }
            FileOutputStream fos = new FileOutputStream(f);
            int len;
            while ((len = jin.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            fos.close();
        }
        jin.closeEntry();
        jin.close();
        input.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}