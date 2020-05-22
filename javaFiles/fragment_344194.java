public void uploadFile(java.io.File fileContent) {
   try {
     com.google.api.services.drive.model.File file = new com.google.api.services.drive.model.File();
     file.setName("filen_ame");

     List<String> parents = new ArrayList<>(1);
     parents.add("parent_folder_id"); // Here you need to get the parent folder id
     file.setParents(parents);

     FileContent mediaContent = new FileContent("your_file_mime_type", fileContent);
     mService.files().create(file, mediaContent).setFields("id").execute();
     Log.d(TAG, "File uploaded");
   } catch (IOException e) {
     Log.e(TAG, "Error uploading file: ", e);
     e.printStackTrace();
   }
}