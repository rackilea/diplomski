while ((s = reader.readLine()) != null)
{
  array = s.split(delimiter);
  String firstName = array[0].trim();
  String lastName = array[1].trim();
  System.out.println(array[0]+array[1]+"\n"+userName+password);
}