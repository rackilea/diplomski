//Make a dir using the users home directory and a filename.
    File dir = new File(System.getProperty("user.home") + "/NameOfDir/");
    //List the files in that dir
    File[] listOfFiles = dir.listFiles();

    //If there are no files, do stuff.
    if (listOfFiles == null) {
        //If the dir doesn't exist already, make it.
        if (!dir.exists()) {
            dir.mkdir();
        }
       //Do stuff in the empty dir
    } else {
        //List the file names in the dir
        List<String> fileNamesList = new ArrayList<String>(Arrays.asList(dir.list()));
        //Do stuff with the files list.
    }