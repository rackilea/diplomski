private File convertMultiPartToFileJDK16(MultipartFile file) throws IOException {           

    File convFile = null;
    FileOutputStream fos = null;

    if (file != null && file.getOriginalFilename() != null) {
        try {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename != null) { 
               convFile = new File(originalFilename); 
               fos = new FileOutputStream(convFile);
               fos.write(file.getBytes());

        }
        catch(IOException ex){
                // handle IOException or rethrow it
        }
        finally {
            fos.close();
        }
    }
    return convFile;
}