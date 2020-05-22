FileInputStream fis;
fis = openFileInput(filePath);
StringBuffer fileContent = new StringBuffer("");

byte[] buffer = new byte[1024];

while ((n = fis.read(buffer)) != -1) 
{ 
  fileContent.append(new String(buffer, 0, n)); 
}
String[] lines = fileContent.toString().split("###");