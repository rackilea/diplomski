public static Map<String, Map<String, Integer>>
              getCallWithStateSizeGroup(ThreadDumpDo threadDumpDo) {
    return replaceAndSortValues(getCallStackWithStateGroup(threadDumpDo),
        m -> replaceAndSortValues(m, List::size, Comparator.<Integer>naturalOrder()),
        Comparator.comparing(m -> m.values().iterator().next()));
}