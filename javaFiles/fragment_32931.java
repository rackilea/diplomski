public List<GameWindow> getWindowsForTime(final long time)
{
    // Submap of start times where the time is lower than or equal to
    // the requested time
    final SortedMap<Long, List<GameWindow>> validStartTimes 
        = startTimes.headMap(time);
    // Submap of end times where the time is greater than or equal to
    // the requested time
    final SortedMap<Long, List<GameWindow>> validEndTimes 
        = endTimes.tailMap(time);

    // Why GameWindow must implement equals and hashCode
    final Set<GameWindow> startSet = new HashSet<>();
    final Set<GameWindow> endSet = new HashSet<>();

    // Insert into the start set all game windows whose start time
    // is less than or equal to the requested time
    for (final List<GameWindow> list: startTimes.headMap(time).values())
        startSet.addAll(list);

    // Insert into the end set all game windows whose end time
    // is greater than or equal to the requested time
    for (final List<GameWindow> list: endTimes.tailMap(time).values())
        endSet.addAll(list);

    // Only retain the intersection of both sets
    startSet.retainAll(endSet);

    // Return the result
    return new ArrayList<>(startSet);
}