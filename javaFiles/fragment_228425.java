public static void main(String[] args) {
    String filename = "notepad.exe";
    String path ="C:\\Windows\\";
    File f = new File(path+"\\"+filename);
    if(f.exists() && f.isFile()) { 
      System.out.println(path+file+" : found");
    }  

    System.out.println("---------------");        
}