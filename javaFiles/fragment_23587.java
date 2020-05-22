for (ListFileItem item : list.getResults()) {
        URI uri = item.getUri();
        String path = uri.getPath();
        String localPath = localRootDirPath;
        String itemName = new File(path).getName();

            CloudFile file = root.getFileReference(itemName);
            file.download(new FileOutputStream(localRootDirPath+itemName));
            CloudFile backupFile = backup.getFileReference(itemName);
            backupFile.startCopy(file);
            file.delete();

            file.download(new 
     FileOutputStream(localRootDirPath+"ok_business"));
 }