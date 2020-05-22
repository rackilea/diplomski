boolean isDirectoryCreated= path.exists();
 if (!isDirectoryCreated) {
     isDirectoryCreated= path.mkdirs();
 }
 if(isDirectoryCreated) {
    // do something
 }