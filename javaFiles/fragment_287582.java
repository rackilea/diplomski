private static int ITEMS_PER_PAGE = 10;

public static List<Integer> getPageStartStop(int page) {
    int start = ITEMS_PER_PAGE * (page-1); // will return 0 for page 1, 10 for page 2, etc...
    int stop = (ITEMS_PER_PAGE * page) + 1; // will return 11 for page 1, 21 for page 2, etc...

    return Arrays.asList(new Integer[] { start, stop });
}