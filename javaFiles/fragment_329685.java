Hashtable <String, LinkedList<String>> table = new Hashtable <String, LinkedList<String>>();

for(String s : new String[]{"cat","dog","mouse", "cat"})
{
     char[] chars = s.toCharArray();
     Arrays.sort(chars);
     String sorted = new String(chars);

     if(table.containsKey(sorted))
     {
         LinkedList<String> list = table.get(sorted);
         list.add(s);
     }
     else
     {
         LinkedList<String> list = new LinkedList<String>();
         list.add(s);
         table.put(sorted, list);
     }
}