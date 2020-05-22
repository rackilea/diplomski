File folder = new File(path); // path is your folder path.
File[] listOfFiles = folder.listFiles(); 

   for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) { 
          //do your stuff
      }
   }