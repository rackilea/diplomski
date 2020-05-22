File file = new File("C:\\");  
 File[] files = file.listFiles();  
 for (File f:files)  
 {  
     System.out.println(f.getAbsolutePath());  
 }