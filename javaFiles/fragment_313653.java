public boolean duplicateExists(List<Event> eventList) {
    Set<Integer> ids = new HashSet<>();
    Set<LocalDateTime> localDateTimes = new HashSet<>();
    return eventList.stream()
            .anyMatch(event -> !ids.add(event.getId()) ||
                    !localDateTimes.add(event.getLocalDateTime()));
}