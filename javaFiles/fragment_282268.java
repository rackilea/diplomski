Map<String,String> map=new HashMap<String,String>();
while(lineReader!=null)
{
String[] tokens = lineReader.split("\\t");
key = tokens[1];
values = tokens[2]+tokens[3];
map.put(key , values );
System.out.println("ID:"+key);
System.out.println("Other Column Values:"+map.get(key));
}