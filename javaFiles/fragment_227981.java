String type = "";
for(int i = 0; i < listOfFiles.length; ++i){
    int extensionLocation = listOfFiles[i].lastIndexOf('.');
    type = listOfFiles[i].getName().substring(extensionLocation);
    //Once you have the type you can do something here.

}