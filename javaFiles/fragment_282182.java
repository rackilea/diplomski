String resultString ="" ;
for(Map.Entry<String,String> entry : map.EntrySet())
{
   String key = entry.getKey();
   String value = entry.getValue();  
   // create custom string for each map element
   String testString = key + "=" + value;
   resultString +=  testString ;
}