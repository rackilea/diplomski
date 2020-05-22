//create a temp dir in the system temp directory to place all the temp files for you app.
private static var tempDir:File=File.createTempDirectory();    

/**
 * bytes - the byte array of the pdf you want to open
 * filename - the name to use for the temp file, you may need to create some type of
 *            counter to add to the beginning of the filename so that you always get
 *            a unique name 
 */
public static openFile(bytes:ByteArray,filename:String):void{
   //create a file in the system temp directory to write the file to
   var tempFile:File = tempDir.resolvePath(filename);

   //create a filestream to write the byte array to the file
   var fileStream:FileStream = new FileStream(); 
   fileStream.open(tempFile, FileMode.WRITE); 
   fileStream.writeBytes(bytes,0,bytes.length);
   fileStream.close();

   //open the temp file with default application
   tempFile.openWithDefaultApplication();
}