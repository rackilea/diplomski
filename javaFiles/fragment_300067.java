byte[] buffer = new byte[8192];
        while ((currentEntry = zipInputStream.getNextEntry()) != null) {
            ZipEntry newEntry = new ZipEntry(currentEntry.getName());
            zipOutputStream.putNextEntry(newEntry);
            int length;
            while ((length = zipInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, length);
            }
            zipOutputStream.closeEntry();                   
        }