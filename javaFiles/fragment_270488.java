public static SongComparator byTitle() {
    return new SongComparator(SongComparator.Order.TITLE_SORT);
}

public static SongComparator byYear() {
    return new SongComparator(SongComparator.Order.YEAR_SORT);
}
...