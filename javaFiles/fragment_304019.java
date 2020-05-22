public void deleteFolder(String bucket, String folderName) throws CoultNotDeleteFile {
  try
  {
    ListResult list = gcsService.list(bucket, new ListOptions.Builder().setPrefix(folderName).setRecursive(true).build());

    while(list.hasNext())
    {
      ListItem item = list.next();
      gcsService.delete(new GcsFilename(file.getBucket(), item.getName()));
    }
  }
  catch (IOException e)
  {
    //Error handling
  }
}