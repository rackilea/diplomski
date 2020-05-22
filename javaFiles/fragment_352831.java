String getPath(){
File file = fc.getSelectedFile();
String source = file.getAbsolutePath();
source .replace("\\","\\\\"); 
return source;
}