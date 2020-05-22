DbxEntry.File fileInfo;
    try {
        fileInfo = dbxClient.getMetadata("/test.txt").asFile();
    }
    catch (DbxException ex) {
        ex.printStackTrace();
        System.err.println("Error in getMetadata(): " + ex.getMessage());
        System.exit(1); return;
    }
    System.out.println("fileInfo name: " + fileInfo.name);
    System.out.println("fileInfo lastModified: " + fileInfo.lastModified);
    System.out.println("fileInfo humanSize: " + fileInfo.humanSize);