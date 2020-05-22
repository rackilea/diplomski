public static void extract(String tgzFile, String outputDirectory)
    throws Exception {

// Create the Tar input stream.
FileInputStream fin = new FileInputStream(tgzFile);
GZIPInputStream gin = new GZIPInputStream(fin);
TarInputStream tin = new TarInputStream(gin);

// Create the destination directory.
File outputDir = new File(outputDirectory);
outputDir.mkdir();

// Extract files.
TarEntry tarEntry = tin.getNextEntry();
while (tarEntry != null) {
    File destPath = new File(outputDirectory + File.separator + tarEntry.getName());

    if (tarEntry.isDirectory()) {
    destPath.mkdirs();
    } else {
    // If the parent directory of a file doesn't exist, create it.
    if (!destPath.getParentFile().exists())
        destPath.getParentFile().mkdirs();

    FileOutputStream fout = new FileOutputStream(destPath);
    tin.copyEntryContents(fout);
    fout.close();
    // Presserve the last modified date of the tar'd files.
    destPath.setLastModified(tarEntry.getModTime().getTime());
    }
    tarEntry = tin.getNextEntry();
}
tin.close();
}