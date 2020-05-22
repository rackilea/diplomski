Map<String, Set<String>> category = new Hashmap<String, Set<String>>();
int largest = 0;
Set<String> largeSet = new HashSet<String>();
for(String d : category.keySet()) {
    if (category.get(d).size() > largest)
        largest = category.get(d).size();
        largeSet = category.get(d);
}
return largeSet;