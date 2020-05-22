parser p = new parser();
String file = "C:\\Users\\RanRag\\test.txt";
FileReader fullPathToAndNameOfFile = new FileReader(file);

if(p.isJson(fullPathToAndNameOfFile))
   System.out.println("valid");
else
   System.out.println("invalid");