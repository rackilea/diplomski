String path = "/mnt/sdcard/dd";

 File fileDir = new File( path );

 if(!fileDir.exists() || !fileDir.isDirectory())
 {
     return;
 }

 String[] files = fileDir.list(); 

 for ( int i = 0 ; i < files.length ; i++  )
 { 
       files[i] = path + "/" +  files[i];
 }