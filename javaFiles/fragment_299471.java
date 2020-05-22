public class DateAwareComparator implements Comparator<DateAware> {

    int compare(DateAware o1, DateAware o2) {
        return Long.compare(o1.getDate(), o2.getDate());
    }

}