File theDir = new File("new folder");

  // if the directory does not exist, create it
  if (!theDir.exists())
  {
    System.out.println("creating directory: " + directoryName);
    boolean result = theDir.mkdir();  
    if(result){    
       System.out.println("DIR created");  
     }

  }
FileOutputStream out = new FileOutputStream(new File(theDir.getAbsolutePath() +"filename"));
BufferedInputStream in = new BufferedInputStream(new URL("URLtoYourFIle").openStream());
byte data[] = new byte[1024];
int count;
        while((count = in.read(data,0,1024)) != -1)
        {
            out.write(data, 0, count);
        }