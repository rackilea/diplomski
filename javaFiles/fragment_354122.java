new File(destPath).mkdirs();
File destFile = new File(destPath + destFileName);
if (destFile.exists()) 
    if (!overwrite) {
        return false;
    } else {
        destFile.delete();
    }
}
destFile.createNewFile();