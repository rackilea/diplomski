public static  void unzip(){
      try{
           BufferedOutputStream out = null;
           ZipInputStream  in = new ZipInputStream(ZipFileExtracter.class.getClassLoader().getResourceAsStream("com/artificialmachines/chitme/stamps/ChitMeData.zip"));
           ZipEntry entry;
           boolean isDirectory=false;
           while((entry = in.getNextEntry()) != null){
               int count;
               byte data[] = new byte[BUFFER];
               // write the files to the disk
               String entryName = entry.getName();
               File newFile = new File(new StringBuffer().append(System.getProperty("user.dir")).append(File.separator).append(entryName).toString());
               if(entryName.endsWith("/")){
                   isDirectory=true;
                   newFile.mkdir();
                   //System.out.println("This is directory "+newFile.exists()+"  IS DIr "+newFile.isDirectory()+"    path "+newFile.getPath());
               }else{
                   newFile.createNewFile();
               }
               if(!isDirectory){
                   out = new BufferedOutputStream(new FileOutputStream(newFile),BUFFER);
                    while ((count = in.read(data,0,BUFFER)) != -1){
                         out.write(data,0,count);
                    }
                    cleanUp(out);
               }
               isDirectory=false;
           }
           cleanUp(in);
      }
      catch(Exception e){
           e.printStackTrace();
           System.exit(0);
      }
   }