input = new BufferedReader(new FileReader(new File(finaName)));
String line = null;
while ((line = input.readLine()) != null) {
  if(line.trim().indexOf('*') == 0)
    continue;
  String[] words = line.split(" "); 
    .... 
}