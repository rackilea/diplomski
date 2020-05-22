BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while ((line = br.readLine()) != null) {
   // process the line. and write into your output file and close the file.
   }
br.close();