public void uploadListener(FileUploadEvent event) {

        try {
            in = event.getUploadedFile().getInputStream();
            fileName = event.getUploadedFile().getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void uploadFile(){
        try {
        String path=some_path + currentReport.getFilename();
        File targetFile = new File(path);

        java.nio.file.Files.copy(
                in, 
          targetFile.toPath(), 
          StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  finally {
            IOUtils.closeQuietly(in);
        }
}