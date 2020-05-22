public void showFiles(File[] files) {
    for (File file : files) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            showFiles(file.listFiles(zipFilenameFilter));
        } else {
            System.out.println("File: " + file.getName());
        }
    }
}