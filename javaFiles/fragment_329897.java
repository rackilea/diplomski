public void add(LocalDateTime time, Task task) {
    tasks.merge(time, Collections.singletonList(task),
        (l1,l2) -> Stream.concat(l1.stream(),l2.stream()).collect(Collectors.toList()));
}

public void remove() {
    for(Map.Entry<LocalDateTime, List<Task>> keyVal : tasks.entrySet()) {
        final List<Task> values = keyVal.getValue();
        if(isSomeCondition(keyVal) && tasks.remove(keyVal.getKey(), values)) {
            for (Task t : values) {
                //do task processing
            }
        }
    }
}