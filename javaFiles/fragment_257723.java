try {
    File input = new File("path/to/your/input/fileOrFolder");
    String destinationPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "zippedItem.zip";
    ZipParameters parameters = new ZipParameters();
    parameters.setCompressionMethod(Zip4jConstants.COMP_STORE);
    parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
    File output = new File(destinationPath);
    ZipFile zipFile = new ZipFile(output);
    // .addFolder or .addFile depending on your input
    if (sourceFile.isDirectory())
        zipFile.addFolder(input, parameters);
    else
        zipFile.addFile(input, parameters);
    // Your input file/directory has been zipped at this point and you
    // can access it as a normal file using the following line of code
    File zippedFile = zipFile.getFile();
} catch (ZipException e) {
    Log.e(TAG, Log.getStackTraceString(e));
}