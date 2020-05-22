HashMap<Text,Integer> m = new HashMap<Text,Integer>();
//Populate the HashMap
while(values.hasNext()) 
{
  Text element = values.next();
  if(m.get(element) == null)
  {
   m.put(element , 1);
  }       
  else m.put(element , m.get(element) + 1);   
}

//Display the frequencies
for (Map.Entry<Text, Integer> entry : m.entrySet())
{
    System.out.println(entry.getValue() + "/" + entry.getKey().period  );
}