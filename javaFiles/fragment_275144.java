class BringToFrontComparator<T extends Comparable<T>> implements Comparator<T> {
    T front;

    public BringToFrontComparator(T front) {
        this.front = front;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.equals(front) && !o2.equals(front)
                // Front one is always less than anything other than itself.
                ? -1
                // Normal comparison elsewhere.
                : o1.compareTo(o2);
    }
}

public void test(String[] args) throws Exception {
    List<String> myList = Arrays.asList("1234", "1214", "1334");
    String mInput = "1334";
    Collections.sort(myList, new BringToFrontComparator<>(mInput));
    System.out.println(myList);
}