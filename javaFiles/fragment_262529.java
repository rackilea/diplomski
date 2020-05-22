File uploadDirectory = new File("your_download_directory");
    File[] downloadedFiles = uploadDirectory.listFiles();

    Arrays.sort(downloadedFiles, new Comparator<File>() {
        @Override
        public int compare(File fileOne, File fileTwo) {
            return Long.valueOf(fileOne.lastModified()).compareTo(fileTwo.lastModified());
        }
    });

    for (File file : downloadedFiles) {
        if (file.isFile()) {
            // upload file
        }
    }