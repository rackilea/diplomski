char c1 = '\0';
char c2 = '\0';
String str = "";
for(int i = 0;i < data.length();++i)
{
 if(data.charAt(i) >= 65&&data.charAt(i) <= 90)
 {
  if(c1 == '\0')
   c1 = data.charAt(i);
  else if(c2 == '\0')
   c2 = data.charAt(i);
  if(c1 != '\0' && c2 != '\0')
   { 
    if(c1 == c2 && str.length() != 0)
     System.out.println("-"+str);
    str = "";
    c1 = c2;
    c2 = '\0';
   }
 }
 else 
  str += data.charAt(i);
}