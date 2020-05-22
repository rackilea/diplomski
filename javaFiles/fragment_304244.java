s = s.replaceAll("[^a-zA-Z0-9]", "/");
String[] splitString = s.split("/");
for(int i=0; i<splitString.length(); i++)
{
   String str = splitString[i];
   System.out.println(str);
}