private void saveMultipartFile( MultipartFile files)
{
    if(!files.isEmpty()){
        try {
            String fileName = files.getOriginalFilename();
            String dirLocation ="Path where you want to save image";
            if(!new File(dirLocation).exists()){
                File file = new File(dirLocation);
                file.mkdirs();
            }
            byte[] bytes = files.getBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dirLocation+new File(fileName)));
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}