public void addGameWindow(final GameWindow window)
{
    final long startTime = window.startTime();
    final long endTime = window.endTime();
    List<GameWindow> list;

    // Insert in start times
    list = startTimes.get(startTime);
    if (list == null) {
        list = new ArrayList<>();
        startTimes.put(startTime, list);
    }
    list.add(window);

    // Insert in end times
    list = endTimes.get(endTime);
    if (list == null) {
        list = new ArrayList<>();
        endTimes.put(endTime, list);
    }
    list.add(window);
}