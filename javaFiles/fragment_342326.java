File directory = new File (".");
 String path = "";
 try {   
        path = directory.getAbsolutePath()
        System.out.println ("Current directory's absolute  path: "+ directory.getAbsolutePath());
 }catch(Exception e) {
     System.out.println("Exceptione is ="+e.getMessage());
 }