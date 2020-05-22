BufferedReader br = new BufferedReader(new FileReader("your file"));
String line;
while ( (line=br.readLine()) != null)
{
         String[] values = line.split(",");    //your seperator

         //Convert String to right type. Integer, double, date etc.
         stat.executeUpdate("INSERT INTO yourTable VALUES('"+value[0]+"','"+value[1]...
         //Use a PeparedStatemant, it´s easier and safer 
}
br.close();