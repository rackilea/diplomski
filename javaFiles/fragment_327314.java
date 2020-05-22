BufferedReader br = new BufferedReader(new FileReader(file));
String line;
boolean found = false;
while ((line = br.readLine()) != null) {
     if(line.equalsIgnoreCase("Your string"))
       found = true;
}