try{
  FileInputStream fis = new FileInputStream(theFileFrCl);
  byte data[] = new byte[fis.available()];
  fis.read(data);
  fis.close();
  toClient.writeBytes(data); // write to client.
}catch(FileNotFoundException fnf)
{
  // File doesn't exists with name supplied by client 
}