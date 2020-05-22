/**
     * Unzips the file (recursively creates sub-folder if exists.)
     * 
     * @param tempFileName
     *            The zip file.
     * @param destinationPath
     *            The destination path where unzipped file will be saved.
     */
    public void unzipFile(String tempFileName, String destinationPath) {
        try {

            int index = destinationPath.lastIndexOf("\\");
            String fileString = destinationPath.substring(index);

            File extFile = new File("/mnt/sdcard/courses1", fileString);
            if(!extFile.exists()) {
                createDir(extFile);
            }

            byte[] buffer = new byte[1024];

            FileInputStream fin = new FileInputStream(tempFileName);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry zipentry = null;
            if (!(zin.available() == 0)) {
                byte[] startBuffer = new byte[8];

                while ((zipentry = zin.getNextEntry()) != null) {
                    String zipName = zipentry.getName();
                    if (zipName.startsWith("/")) {
                        zipName = zipentry.getName();
                    } else if (zipName.startsWith("\\")) {
                        zipName = zipentry.getName();
                    } else {
                        zipName = "/" + zipentry.getName();
                    }

                    String fileName = destinationPath + zipName;
                    fileName = fileName.replace("\\", "/");
                    fileName = fileName.replace("//", "/");

                    if (zipentry.isDirectory()) {
                        createDir(new File(fileName));
                        continue;
                    }

                    String name = zipentry.getName();
                    int start, end = 0;
                    while (true) {

                        start = name.indexOf('\\', end);
                        end = name.indexOf('\\', start + 1);
                        if (start > 0)
                            "check".toString();
                        if (end > start && end > -1 && start > -1) {
                            String dir = name.substring(1, end);

                            createDir(new File(destinationPath + '/' + dir));
                            // name = name.substring(end);
                        } else
                            break;
                    }

                    File file = new File(fileName);

                    FileOutputStream tempDexOut = new FileOutputStream(file);
                    int BytesRead = 0;

                    if (zipentry != null) {
                        if (zin != null) {
                            while ((BytesRead = zin.read(buffer)) != -1) {
                                tempDexOut.write(buffer, 0, BytesRead);
                            }
                            tempDexOut.close();
                        }
                    }
                }
            }

        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }