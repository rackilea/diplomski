private static void zipFolder(String inputFolderPath, String outZipPath)  {
try {
    FileOutputStream fos = new FileOutputStream(outZipPath);
    ZipOutputStream zos = new ZipOutputStream(fos);
    File srcFile = new File(inputFolderPath);
    File[] files = srcFile.listFiles();
    Log.d("", "Zip directory: " + srcFile.getName());
    for (int i = 0; i < files.length; i++) {
        Log.d("", "Adding file: " + files[i].getName());
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(files[i]);
        zos.putNextEntry(new ZipEntry(files[i].getName()));
        int length;
        while ((length = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, length);
        }
        zos.closeEntry();
        fis.close();
    }
    zos.close();
} catch (IOException ioe) {
    Log.e("", ioe.getMessage());
}
}