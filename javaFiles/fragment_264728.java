List<String> names = new ArrayList<>();
Map<Character,Integer> map = new HashMap<>();
for (String name : names)
  {
  char firstLetter = name.charAt(0);
  if( map.containsKey(firstLetter) )
    map.put(firstLetter, map.get(firstLetter)+1 );
  else
    map.put(firstLetter, 1);
  }