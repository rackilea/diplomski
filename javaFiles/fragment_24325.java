public static List<Task> convert(Collection<Task> input) {
    NavigableMap<LocalDate, Set<String>> map = new TreeMap<>();
    map.put(LocalDate.MIN, new HashSet<>());

    for (Task task : input) {
        if (!map.containsKey(task.start)) {
            map.put(task.start, new HashSet<>(map.lowerEntry(task.start).getValue()));
        }
        if (!map.containsKey(task.end)) {
            map.put(task.end, new HashSet<>(map.lowerEntry(task.end).getValue()));
        }
        for (Set<String> set : map.subMap(task.start, task.end).values()) {
            set.addAll(task.actionItems);
        }
    }
    List<Task> result = new ArrayList<>();
    LocalDate prev = null;
    Set<String> prevValues = Collections.emptySet();
    for (Entry<LocalDate, Set<String>> entry : map.entrySet()) {
        if (!prevValues.isEmpty()) {
            result.add(new Task(prev, entry.getKey(), prevValues));
        }
        prev = entry.getKey();
        prevValues = entry.getValue();
    }
    return result;
}