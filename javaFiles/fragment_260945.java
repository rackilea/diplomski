while ((sCurrentLine = br.readLine()) != null) {
    // For every line in the reader...

    //NOTE: I strongly advise renaming theKeywords to something more descriptive!
    for (String dayOfWeek : theKeywords) {
        // For each day of the week, count how many times that key shows up.
        int occurrences = sCurrentLine.split(dayOfWeek, -1).length - 1;

        // Now increase the appropriate counter by the number of occurrences (0+)
        DayCount.put(dayOfWeek, (Integer) DayCount.get(dayOfWeek) + occurrences);
    }
}