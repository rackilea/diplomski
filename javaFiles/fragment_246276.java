FileItem file = (FileItem)items.get(0);
//Create a temporary file.
File myFile = File.createTempFile(base, extension);
//Write contents to temporary file.
file.write(myFile);

/**
* Do whatever you want with the temporary file here...
*/

//Delete the temporary file.
myFile.delete(); //-OR- myFile.deleteOnExit();