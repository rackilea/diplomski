FileInputStream fis;
fis = openFileInput("test.txt");
StringBuffer fileContent = new StringBuffer("");

byte[] buffer = new byte[1024];

while ((n = fis.read(buffer)) != -1) 
{ 
  fileContent.append(new String(buffer, 0, n)); 
}