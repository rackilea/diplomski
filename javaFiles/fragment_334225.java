/*
 * Search for files in the folder and copy
 * them into a zip file.
 */

//Your files
File folder = new File("C:\\Java\\Example\\");
File destination = new File("C:\\Java\\ZipFile.zip");

//Output streams for writing the zip file
FileOutputStream fos = new FileOutputStream(destination);
ZipOutputStream zos = new ZipOutputStream(fos);

//Search for files in the directory, ignore sub-directories
for(File file : folder.listFiles()) {
    if(file.isDirectoy())
        continue;

    //Create a zip entry and set the ZipOutputStream to
    //write a new file inside the zip file.
    ZipEntry entry = new ZipEntry(file.getName());
    zos.putNextEntry(entry);

    //Open a FileInputStream to read from the current file
    FileInputStream fis = new FileInputStream(file);

    //Stream the contents of the file directly
    //to the ZipOutputStream
    int length;
    byte[] buffer = new byte[1024];
    while((length = fis.read(buffer)) > 0) {
        zos.write(buffer, 0, len);
    }

    //Close the input stream and the zip
    //entry for the next file
    fis.close();
    zos.closeEntry();
}

//Close the ZipOutputStream
zos.close();