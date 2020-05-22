String path = servletContext.getRealPath("/MyProps/MyProperty.properties");       
System.out.println("path: " + path);      
Properties prop = new Properties();       
try {      
   File f = new File(path);      
   FileInputStream fis = new FileInputStream(f);     
   prop.load(fis);    
}
catch (Exception e) {   
   e.printStackTrace();   
}