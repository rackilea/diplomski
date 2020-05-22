...
//Insert right after the JFilechoser is created
inFileName2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
...
public void multiFile(JFileChooser inFileName) throws FileNotFoundException, IOException {

    checksumFinder cf = new checksumFinder(this);//Calls the class to read the file

     File[] listAllFiles = inFileName.getSelectedFile().listFiles

    for (int i = 0; i < listAllFiles.length; i++) {

        File currentFile = listAllFiles[i];

        if (currentFile.isFile() && currentFile.getName().endsWith(".pcf")) {
            cf.hexFinder(currentFile, null, null, null);
        } 
     }