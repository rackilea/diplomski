public String extractInputStream() {

    ZipInputStream is = null;
    String extracted = null;

    try {
        // get the zip
        ZipFile zipFile = new ZipFile("/path/to/my/file.zip");

        // set the password
        if (zipFile.isEncrypted()) {
            zipFile.setPassword("password");
        }
        //get the file inside the zip
        FileHeader fileHeader = zipFile.getFileHeader("yourfile.txt");

            if (fileHeader != null) {
                        is = zipFile.getInputStream(fileHeader);
                        //edited
                        extracted = new Scanner(is,"UTF-8").useDelimiter("\\A").next();
                        //edited
                        is.close();

        }
    } catch (ZipException e) {
        e.printStackTrace(); //make something better here
    } catch (FileNotFoundException e) {
        e.printStackTrace();//make something better here
    } catch (IOException e) {
        e.printStackTrace();//make something better here
    } catch (Exception e) {
        e.printStackTrace();//make something better here
    } 
    return extracted;
}