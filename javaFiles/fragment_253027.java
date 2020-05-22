List<String> copiedLines = new ArrayList<>();  
String line;  
while ((line = read.readLine()) != null)  
{
  copiedLines.add(line);  
}  
String[] textLines = copiedLines.toArray(new String[0]);