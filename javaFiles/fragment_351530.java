public static MyEvent getMostRecentLastEventOfSequence(
    SortedSet<MyEvent> events, List<String> sequence) {

    String first = sequence.get(0), second = sequence.get(1);
    UnaryOperator<MyEvent> previous;
    if (events instanceof NavigableSet) {
        NavigableSet<MyEvent> navigableSet = (NavigableSet<MyEvent>) events;
        previous = navigableSet::lower;
    }
    else previous = event -> events.headSet(event).last();

    return events.stream()
        .filter(event -> event.getAbbreviation().equals(second))
        .filter(event -> {
            MyEvent p = previous.apply(event);
            return p != null && p.getAbbreviation().equals(first);
        })
        .max(Comparator.naturalOrder()).orElse(null);
}