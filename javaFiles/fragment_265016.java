while(s != null)
{
  array = s.split(delimiter);
  String firstName = array[0];
  String lastName = array[1];
  System.out.println(array[0]+array[1]+"\n"+firstName+lastName);   // <-- this prints 2 lines of output
  s=reader.readLine();
}