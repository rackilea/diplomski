File newFile = new File("folder", newFileName.getText() + ".properties");
File parentFile = newFile.getParentFile();
if (parentFile.exists() || parentFile.mkdirs()) {
    if (!newFile.exists()) {
        if (newFile.createNewFile()){
            //do sth...
        } else {
            throw new IOException("Could not create " + newFile + ", you may not have write permissions or the file is opened by another process");
        }
    }
} else {
    throw new IOException("Could not create directory " + parentFile + ", you may not have write permissions");
}