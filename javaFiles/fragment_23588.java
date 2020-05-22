CloudFile file;
for (ListFileItem item : list.getResults()) {
        URI uri = item.getUri();
        String path = uri.getPath();
        String localPath = localRootDirPath;
        String itemName = new File(path).getName();

            file = root.getFileReference(itemName);
            file.download(new FileOutputStream(localRootDirPath+itemName));
            CloudFile backupFile = backup.getFileReference(itemName);
            backupFile.startCopy(file);
            file.delete();
 }

   // preventing Null Pointer Exception for cases, when file is not initialized
   if (file!=null) {
       file.download(new FileOutputStream(localRootDirPath+"ok_business"));
   }