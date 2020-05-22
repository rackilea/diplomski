public static Map<String, Map<String, List<ThreadDo>>>
              getCallWithStateSizeGroup(ThreadDumpDo threadDumpDo) {
    return replaceAndSortValues(getCallStackWithStateGroup(threadDumpDo),
        m -> replaceAndSortValues(m, Function.identity(),
                                  Comparator.comparingInt(List::size)),
        Comparator.comparingInt(m -> m.values().iterator().next().size()));
}