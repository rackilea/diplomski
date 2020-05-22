List<String> resultList = new ArrayList<String>();
String lastName = null;
while (( line = bf.readLine()) != null){
   if (line.trim().length() == 0) lastName = null;
   else if (lastName == null) lastName = line;
   int indexfound = line.indexOf(stilius);
   if (indexfound > -1) {
      counter++;
      resultList.add(lastName);
   }
//do something with resultList, which contains the names
}