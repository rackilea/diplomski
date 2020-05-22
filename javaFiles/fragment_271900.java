class CountingComparator<T extends Comparable<T>> extends Comparator<T> {

      private int count = 0;
      public int compare(T o1, T o2) {
        ++count;
        return o1.compareTo(o2);
      }

      public int getCount() { return count; }
}