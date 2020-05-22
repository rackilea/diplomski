while ((sCurrentLine = br.readLine()) != null) {
    // For every line in the reader...

    for (String dayOfWeek : (Set<String>) DayCount.keySet()) {
        // For each day of the week (the keys in the DayCount map), count how
        // many times that key shows up in the line.
        int occurrences = sCurrentLine.split(dayOfWeek, -1).length - 1;

        // Now increase the appropriate counter by the number of occurrences (0+)
        DayCount.put(dayOfWeek, (Integer) DayCount.get(dayOfWeek) + occurrences);
    }
}