Collection<Translation> translations = someMap.values();
Set<Translation> dupeSet = new HashSet<>();

for (Translation t : translations) {
    if (Collections.frequency(translations, t) > 1) {
        dupeSet.add(t);
    }
}