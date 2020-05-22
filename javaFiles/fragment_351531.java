public static MyEvent getMostRecentLastEventOfSequence(
    SortedSet<MyEvent> events, List<String> sequence) {

    String first = sequence.get(0), second = sequence.get(1);
    UnaryOperator<MyEvent> previous;
    Stream<MyEvent> stream;
    if (events instanceof NavigableSet) {
        NavigableSet<MyEvent> navigableSet = (NavigableSet<MyEvent>) events;
        previous = navigableSet::lower;
        stream = navigableSet.descendingSet().stream();
    }
    else {
        previous = event -> events.headSet(event).last();
        stream = Stream.iterate(events.last(), previous).limit(events.size());
    }

    return stream
        .filter(event -> event.getAbbreviation().equals(second))
        .filter(event -> {
            MyEvent p = previous.apply(event);
            return p != null && p.getAbbreviation().equals(first);
        })
        .findFirst().orElse(null);
}