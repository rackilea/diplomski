ZipInputStream zip = null;
    try {
        zip = new ZipInputStream(url.openStream());

        ZipEntry entry;
        do{
            entry = zip.getNextEntry();
        } while(!yourExpectedFileName.equals(entry.getName())


        while(zip.available()){
             //read your data
        }
        zip.closeEntry();

    } finally {
        if (zip != null)
            zip.close();
    }