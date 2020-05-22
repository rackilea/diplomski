BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while ((line = br.readLine()) != null) {
   // process the line.
   if (line.equals(". "))
   {
       // Do something with first line
       line = br.readLine()
       // Do something with second line
       line = br.readLine()
       // Split up the third line by space 
       String split[]= StringUtils.split(line); // split[1] = "Mozart," so you may need to do a little more work there
   }
}
br.close();