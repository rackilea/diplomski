BufferedReader reader1 = ...; // depends on your source
BufferedReader reader2 = ...; // depends on your source

String line1 = null;
String line2 = null;

while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null)
{
     if (line1.equals(line2))
     {

     }
}