File dir = new File("D:/arc");
    FileOutputStream fos = new FileOutputStream(new File(
            "d:/arc/archieve-full.zip"));
    FileInputStream fis = null;
        Set<String> files = new TreeSet<String>();
        for (String fname : dir.list()) {
            files.add(fname);
        }
        for (String fname : files) {
        try {
            fis = new FileInputStream(new File(dir.getAbsolutePath(), fname));
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fos.write(b);
        } finally {
            if (fis != null) {
                fis.close();
            }
            fos.flush();
        }
    }
    fos.close();
    ZipFile zipFile = new ZipFile("d:/arc/archieve-full.zip");
    /*extract files from zip*/