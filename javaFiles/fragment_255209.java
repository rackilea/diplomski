UnzipUtility unzipUtility = new UnzipUtility();
try {
    unzipUtility.unzip(localFilePath, parentPath);
} catch (IOException e) {
    e.printStackTrace();
}