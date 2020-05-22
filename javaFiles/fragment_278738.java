public static void copyFile(File sourceFile, File destFile) throws IOException {
    if(!destFile.exists()) {
        destFile.createNewFile();
    }

    FileChannel source = null;
    FileChannel destination = null;
    try {
        source = new FileInputStream(sourceFile).getChannel();
        destination = new FileOutputStream(destFile).getChannel();

        // previous code: destination.transferFrom(source, 0, source.size());
        // to avoid infinite loops, should be:
        long count = 0;
        long size = source.size();              
        while((count += destination.transferFrom(source, count, size-count))<size);
    }
    finally {
        if(source != null) {
            source.close();
        }
        if(destination != null) {
            destination.close();
        }
    }
}