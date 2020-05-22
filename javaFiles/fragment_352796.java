public static File unGzip(File infile, boolean deleteGzipfileOnSuccess) throws IOException {
    GZIPInputStream gin = new GZIPInputStream(new FileInputStream(infile));
    FileOutputStream fos = null;
    try {
        File outFile = new File(infile.getParent(), infile.getName().replaceAll("\\.gz$", ""));
        fos = new FileOutputStream(outFile);
        byte[] buf = new byte[100000];
        int len;
        while ((len = gin.read(buf)) > 0) {
            fos.write(buf, 0, len);
        }

        fos.close();
        if (deleteGzipfileOnSuccess) {
            infile.delete();
        }
        return outFile; 
    } finally {
        if (gin != null) {
            gin.close();    
        }
        if (fos != null) {
            fos.close();    
        }
    }       
}