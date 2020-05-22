s = s.replaceAll("[^a-zA-Z0-9]", "/");
String[] splitString = s.split("/");
for(String str:splitString)
{
   System.out.println(str);
}