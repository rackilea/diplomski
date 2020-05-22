Map<String,String> data = new HashMap<>();
FileReader fr = new FileReader(fileToRead);
String str = "";
while((str = fr.readLine()) != null){
   String s = str.split(": ");
   data.add(s[0],s[1]);
 }

 return data;