public static void main (String[] args)
   {
      String fileName = args[0];
      try{
         File file = new File(System.getProperty("oozie.action.output.properties"));
         Properties props = new Properties();
         props.setProperty("PASS_ME", "123456");

         OutputStream os = new FileOutputStream(file);
         props.store(os, "");
         os.close();
         System.out.println(file.getAbsolutePath());
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }