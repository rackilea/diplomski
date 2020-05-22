try {
        ZipInputStream zipInputStream = new ZipInputStream(
            new FileInputStream("D:/dev/... .zip"));
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println("- " + zipEntry.getName()
                + " #" + zipEntry.getSize());
            if (zipEntry.isDirectory()) {
                zipInputStream.closeEntry();
                continue;
            }

            long size = zipEntry.getSize();
            if (size > Integer.MAX_VALUE) {
                throw new IOException("File too large: " + zipEntry.getName());
            }
            int reserved = size == -1L ? 8192 : (int)size; 
            ByteArrayOutputStream baos = new ByteArrayOutputStream(reserved);
            IOUtils.copy(zipInputStream, baos);
            zipInputStream.closeEntry();

            baos.close();
            File file = new File("D:/dev/data/temp/" + zipEntry.getName());
            file.getParentFile().mkdirs();
            FileUtils.writeByteArrayToFile(file, baos.toByteArray());
        }
    } catch (IOException ex) {
        Logger.getLogger(Stackoverflow.class.getName()).log(Level.SEVERE, null, ex);
    }