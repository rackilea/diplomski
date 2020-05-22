File[] listOfFiles = folder.listFiles();
    List<String> listOfFileNames = new List<String>();
    for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            listOfFileNames.add(listOfFiles[i].getName());
          };
    listTypeADecks.setListData(listOfFileNames.toArray());