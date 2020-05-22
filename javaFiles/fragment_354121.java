File destDir = new File(destPath);
if (destDir.exists() == false) {
    if (createDestDir == false) return false;
    if (destDir.mkdirs() == false) {
        return false;
    }
}
File destFile = new File(destPath + destFileName);
if (destFile.exists()) {
    if (overwrite == false) return false;
    if (destFile.delete() == false) {
       return false;
    }
}