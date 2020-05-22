private static class BookingTuple implements Comparable<BookingTuple> {
    public final Date date;
    public final boolean isStart;
    public final int id;
    public BookingTuple(Date date, boolean isStart, int id) {
        this.date = date;
        this.isStart = isStart;
        this.id = id;
    }

    @Override
    public int compareTo(BookingTuple other) {
        int dateCompare = date.compareTo(other.date);
        if (dateCompare != 0) {
            return dateCompare;
        } else {
            if (!isStart && other.isStart) {
                return -1;
            } else if (isStart && !other.isStart) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

public static boolean isOverlappingDates(List<BookingDateRange> dateRangeList, List<String> overlappingDatePairs) {
    List<BookingTuple> list = new ArrayList<BookingTuple>();
    for (int i = 0; i < dateRangeList.size(); i++) {
        Date from = dateRangeList.get(i).getFromDate();
        Date to = dateRangeList.get(i).getToDate();
        list.add(new BookingTuple(from, true, i));
        list.add(new BookingTuple(to, false, i));
    }

    Collections.sort(list);

    boolean overlap = false;

    HashSet<Integer> active = new HashSet<Integer>();
    for (BookingTuple tuple : list) {
        if (!tuple.isStart) {
            active.remove(tuple.id);
        } else {
            for (Integer n : active) {
                overlappingDatePairs.add(n + "_" + tuple.id);
                overlap = true;
            }
            active.add(tuple.id);
        }
    }

    return overlap;
}