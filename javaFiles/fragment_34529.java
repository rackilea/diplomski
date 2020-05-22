SortedMap<Integer, Entry> mergedEntriesMap = new TreeMap<Integer, Entry>();
for (Entry e : entries) {
  if (mergedEntriesMap.contains(e.id)) {
    Entry m = mergedEntriesMap.get(e);
    m.regions.addAll(e.regions);
  } else {
    Entry m = new Entry();
    // copy the entry to keep the original array clean
    m.id = e.id;
    m.name = e.name;
    m.regions = new ArrayList<Region>(e.regions);
    mergedEntriesMap.put(m.id, m);
  }
}

List<Entry> mergedEntries = new ArrayList<Entry>(mergedEntriesMap.values());