public OutputStream loadFile(URL remoteFile, JProgressBar progress) throws IOException
{
    URLConnection connection = remoteFile.openConnection(); //connect to remote file
    InputStream inputStream = connection.getInputStream(); //get stream to read file

    int length = connection.getContentLength(); //find out how long the file is, any good webserver should provide this info
    int current = 0;

    progress.setMaximum(length); //we're going to get this many bytes
    progress.setValue(0); //we've gotten 0 bytes so far

    ByteArrayOutputStream out = new ByteArrayOutputStream(); //create our output steam to build the file here

    byte[] buffer = new byte[1024];
    int bytesRead = 0;

    while((bytesRead = inputStream.read(buffer)) != -1) //keep filling the buffer until we get to the end of the file 
    {   
        out.write(buffer, current, bytesRead); //write the buffer to the file offset = current, length = bytesRead
        current += bytesRead; //we've progressed a little so update current
        progress.setValue(current); //tell progress how far we are
    }
    inputStream.close(); //close our stream

    return out;
}