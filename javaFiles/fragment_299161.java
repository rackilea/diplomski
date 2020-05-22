public static void main(String[] args) throws IOException {
        ZipFile zipFile = new ZipFile("/Users/yelinaung/Desktop/unzip/epub/doyle.epub");
        String path = "/Users/yelinaung/Desktop/unzip/xml/";

        Enumeration files = zipFile.entries();

        while (files.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) files.nextElement();
            if (entry.isDirectory()) {
                File file = new File(path + entry.getName());
                file.mkdir();
                System.out.println("Create dir " + entry.getName());
            } else {
                File f = new File(path + entry.getName());
                FileOutputStream fos = new FileOutputStream(f);
                InputStream is = zipFile.getInputStream(entry);
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                fos.close();
                System.out.println("Create File " + entry.getName());
            }
        }
    }