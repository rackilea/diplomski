List<String> linkList=new ArrayList<String>();
  fileFlag=0;
  pageToken = null;
  do {
      driveFiles = service.files().list()
              .setQ("mimeType!='application/vnd.google-apps.folder' and '"+childFolder.getId()+"' in parents ")
              .setSpaces("drive")
              .setFields("nextPageToken, files(id, name, webContentLink)")
              .setPageToken(pageToken)
              .execute();
      System.out.println("\n\nFile No. : "+driveFiles.getFiles().size());
      for(com.google.api.services.drive.model.File file: driveFiles.getFiles()) {
         linkList.add(file.getWebContentLink());
         System.out.println(file.getName());
         System.out.println("File Link : "+file.getWebContentLink());
         System.out.println(file.getId());
         System.out.println(file.getWebViewLink());
      }
      pageToken = driveFiles.getNextPageToken();
  } while (pageToken != null);