//This will return the build absolute path in ss variable
   StringSelection ss=new StringSelection(uploadfile().getAbsolutePath()+"\\"+"TestJpegFile.jpeg");
   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);


//Call this function while setup your path 
public File uploadfile()
    {
        File datadir=new File("InputData\\images\\");
           try
           {
               if(!datadir.exists())
               {
                   datadir.mkdir();
               }
           }catch(Exception e)
           {
               e.printStackTrace();
           }
           return datadir;
    }