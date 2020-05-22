Map<String, Record> newMap = new TreeMap<String, Record>();
for(String[] ss : acquisitions) {
    Record rec = Record.parse(ss); // For requirement (1)
    newMap.put(rec.getName(), rec);
}

for(String[] ss : inventory) {
    Record rec = Record.parse(ss); // For requirement (1)
    if(newMap.containsKey(rec.getName())) {
        // For requirement (2)
        // The mergeWith method can then add quantities together
        newMap.get(rec.getName()).mergeWith(rec);
    } else {
        // For requirement (3)
        newMap.put(rec.getName(), rec);
    }
}