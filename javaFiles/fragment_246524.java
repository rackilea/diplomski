entries = unmarshaller.unmarshal(...);
Map<String, Entry> compacted_entries = new HashMap<String, Entry>();
for (Entry entry: entries) {
   if compacted_entries.containsKey(entry.name)
     compacted_entries.get(entry.name).colors.add(entry.color);
   else
     compacted_entries.put(entry.name, entry);
     entry.colors = new HashSet<String>();
     entry.colors.add(entry.color);
   end
}