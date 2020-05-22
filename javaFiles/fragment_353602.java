public File getFileOfMultipartFile(MultipartFile multipartFile) throws IOException {
    File convFile = new File(multipartFile.getOriginalFilename());
    convFile.createNewFile();
    FileOutputStream fos = new FileOutputStream(convFile);
    fos.write(multipartFile.getBytes());
    fos.close();
    return convFile;
}