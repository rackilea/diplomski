ArrayList<String> myList = new ArrayList<String>();
while(!myQueue.isEmpty()) {
    myList.add((String)myQueue.dequeue());
}


TreeMap<Character, Integer> counts = new TreeMap<Character, Integer>();
for(int i = 0; i < myList.size(); i++) {
    String country = myList.get(i);
    Character first = Character.toUpperCase(country.charAt(0));
    if(counts.get(first) == null) {
        counts.put(first, 0);
    }
    counts.put(first, counts.get(first) + 1);
}
//Now print the counts

TreeSet<Character> keySet = new TreeSet<Character>(counts.keySet());
Iterator<Character> iterator = keySet.iterator();
while(iterator.hasNext()) {
    Character key = iterator.next();
    System.out.println("Total number of countries start with " + key + " : " + counts.get(key));
}