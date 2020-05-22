public class ReverseIntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer first, Integer second) {
        return second.compareTo(first);
    }
}