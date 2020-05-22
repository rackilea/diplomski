ListIterator listIterator = line.listIterator();
if(lineNumber == 1)
{
    while(listIterator.hasNext())
    {   
        String key = listIterator.next().toString();
        keyList.add(key); // keyList is a List<String> instance field.
        hashMap.put(key, new ArrayList<String>());
    }
} else {
    Iterator<String> keyIterator = keyList.iterator();
    while(keyList.hasNext() && listIterator.hasNext())
    {
        String key = keyList.next();
        String value = listIterator.next();
        ArrayList<String> values = hashMap.get(key);
        values.add(value);
    }
}