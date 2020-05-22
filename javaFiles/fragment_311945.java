public static int OccurenceFinder(String source, String pattern) {
    int counter = 0;
    int index = source.indexOf(pattern);
    if (index == -1) return 0;
    counter++;
    while (true) {
        index = source.indexOf(pattern, index + 1);
        if (index == -1) return counter;
        counter++;
    }

}