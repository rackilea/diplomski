public class MapAdder {
    private Map<String, Set<String>> app2entryMap = new HashMap<>();

    ...

    public boolean addMapping(final String app, final String entry) {
        Set<String> entries = app2entryMap.get(app);

        if (entries == null) {
            entries = new HashSet<String>();
            app2entryMap.put(app, entries);
        }

        return entries.add(entry);
    }
}