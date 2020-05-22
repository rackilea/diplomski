{
    long start = 1497584001010L;
    long end =   1497584008000L;

    System.out.println("Diff: " + (end - start));

    int compactStart = compact(start);
    int compactEnd = compact(end);

    System.out.println("Compact Start: " + compactStart);
    System.out.println("Compact End:   " + compactEnd);

    System.out.println("Diff: " + (expand(compactEnd) - expand(compactStart)));

}

private int compact(long millis) {
    return (int)((millis - 1497580000000L)/100);
}

private long expand(int millis) {
    return (millis + 1497584000000L)*100;
}