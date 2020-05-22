File folder = new File("your/path");
File[] listOfFiles = folder.listFiles();

for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) {
        if(listOfFiles[i].lastModified() > FROM && listOfFiles[i].lastModified() < TO){
                doSomething();
        }
    }
}