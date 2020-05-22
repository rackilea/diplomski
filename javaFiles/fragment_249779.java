String str="John,White,\"Some-Company, Inc.\",\"Network Manager, Architect\",xyz@abc.com,,,";
Vector<String> v=new Vector<String>(8);
for (int i=0;i<8;i++) v.add("");

String regex="\"([^\"]*)\"|([^,\\s][^\\,]*[^,\\s]*)";
m=Pattern.compile(regex).matcher(str);
int index=0;
while (m.find())
{
  if (m.group(1) != null) v.set(index,"Quoted [" + m.group(1) + "]");
  else v.set(index," Plain [" + m.group(2) + "]");
  index++;
}
for (int i=0;i<v.size();i++) System.out.println("<"+(i+1)+"> "+v.elementAt(i));