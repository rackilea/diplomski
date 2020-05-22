public void reverseMap()
{
    NavigableMap<Integer,String> map = new TreeMap<Integer,String>();
    LinkedHashMap<Integer,String> reverseMap = new LinkedHashMap<Integer,String>();
map.put(1,"Apple");
    map.put(2,"Ball");
map.put(3,"Cat");
NavigableSet<Integer> keySet = map.navigableKeySet();
Iterator<Integer> iterator = keySet.descendingIterator();
Integer i;
while(iterator.hasNext())
{
    i = iterator.next();
    reverseMap.put(i,map.get(i));
}
System.out.println(reverseMap);
}