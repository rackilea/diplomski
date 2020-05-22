public static void main(String[] args) {

    String fullPath;
    String pathSeparator = "\\";
    String extSeparator = ".";
    String path = "U:\\Grafik\\Stack\\testExt\\";
    String filename = "Pic24.gif";
    String searchtext;    
    String[] elements = { ".jpg",".png",".jpeg"};           
    fullPath = path+filename;
    int dot = fullPath.lastIndexOf(extSeparator);
    searchtext = fullPath.substring(0, dot);

    for (String s: elements) {           
        File f = new File(searchtext+s);
          if(f.exists() && f.isFile()) {
           System.out.println("found : "+searchtext+s);
          } else {
           System.out.println("not found : "+searchtext+s);
          }
    }
    }
}