List<String> data = ...;
List<String> finalData = new ArrayList<>();
Map<String, Integer> counts = new HashMap<>();

for(String s : data) {
    counts.merge(s, 1, Integer::sum);  // Keep track of occurences seen

    int occurences = counts.get(s);  // Get how many there are for s

    if(occurences == 1) { 
        finalData.add(s);
    }
    else {  // if more than 1, change the string
        finalData.add(s + (occurences - 1));
    }
}