String[] array =
Set<String> found = new LinkedHashSet<String>();
for(int i=0;i<array.length;i++)
   if(!found.add(array[i]))
       array[i] = null;

// just the entries without duplicates.
String[] unique = found.toArray(new String[found.size()]);