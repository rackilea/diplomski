void caller()
{
  String s1="Hello";
  updateString(s1);
  System.out.println(s1);
}
void updateString(String s1)
{
  s1="Goodbye";
}