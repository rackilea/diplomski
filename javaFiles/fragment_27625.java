public static void main(String[] args) {
File folder = new File("{FilePath}");
File[] listOfFiles = folder.listFiles();
for(int i = 0; i < listOfFiles.length; i++){
String filename = listOfFiles[i].getName();
if(filename.endsWith(".xml")||filename.endsWith(".XML"))
{
System.out.println(filename);
}
   }
  }
 }