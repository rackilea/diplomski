if (file.isDirectory())
    FileUtils.deleteDirectory(File directory);
else {
    if(!file.delete())
        throw new IOException("Failed to delete " + file);
}