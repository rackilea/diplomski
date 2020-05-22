public static boolean contentEquals(File file1, File file2) throws IOException {
    boolean file1Exists = file1.exists();
    if (file1Exists != file2.exists()) {
        return false;
    }

    if (!file1Exists) {
        // two not existing files are equal
        return true;
    }

    if (file1.isDirectory() || file2.isDirectory()) {
        // don't want to compare directory contents
        throw new IOException("Can't compare directories, only files");
    }

    if (file1.length() != file2.length()) {
        // lengths differ, cannot be equal
        return false;
    }

    if (file1.getCanonicalFile().equals(file2.getCanonicalFile())) {
        // same file
        return true;
    }

    InputStream input1 = null;
    InputStream input2 = null;
    try {
        input1 = new FileInputStream(file1);
        input2 = new FileInputStream(file2);
        return IOUtils.contentEquals(input1, input2);

    } finally {
        IOUtils.closeQuietly(input1);
        IOUtils.closeQuietly(input2);
    }
}