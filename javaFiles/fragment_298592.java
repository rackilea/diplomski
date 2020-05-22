private File convertMultiPartToFileJDK17(MultipartFile file) throws IOException {           
    File convFile = null;
    if (file != null && file.getOriginalFilename() != null) {

        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null) { 
           convFile = new File(originalFilename); 

           try(FileOutputStream fos = new FileOutputStream(convFile);) {
              fos.write(file.getBytes());
           }
         }
    }
    return convFile;
}