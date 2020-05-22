BoxFolder bfolder = BoxFolder.getRootFolder(api);
Iterator<BoxFolder.Info> it = bfolder.getChildren().iterator();
for(BoxFolder.Info i : it){
  if(i.getName().equals(subfolder1)){
    BoxFolder folder = new BoxFolder(api, i.getID());
    FileInputStream stream= null;
    filePath = "c:\\UploadFile.txt";
    stream = new FileInputStream(filePath);
    fileName = FilenameUtils.getBaseName(filePath.toString());
    folder.uploadFile(stream, fileName);
    break;
  }
}