private static String getWWWDir() {
       String dir = new File("").getAbsolutePath() + "/www";
       File file = new File(dir);

       if(file.exists() && file.isDirectory()) {
           return file.getAbsolutePath();
       }
       else
       {
           String tmpDir = API.class.getProtectionDomain().getCodeSource().getLocation().getFile();
           file = new File(tmpDir);
           dir = file.getParent() + "/www";
           file = new File(dir);
           if(file.exists() && file.isDirectory()) {
               return file.getAbsolutePath();
           }
       }
       return null;
   }