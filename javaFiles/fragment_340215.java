File zipFile = new File(fileName.replace("XLS", "ZIP"));
        FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        addFileToZip("", fileName, zipOutputStream, false);
        zipOutputStream.flush();
        zipOutputStream.close();