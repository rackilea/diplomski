// already exists:
List<String[]> lessons = ...

// final format
final HashMap<String, List<String[]>> titleHashMap = new HashMap<String, List<String[]>>();

for (String[] lesson : lessons) {
    final String level = lesson[2];
    if (!titleHashMap.containsKey(level)) {
        titleHashMap.put(level, new ArrayList<String[]>());
    }
    titleHashMap.get(level).add(lesson);
}