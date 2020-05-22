public static int bSearch(ArrayList<Integer> tab, int key) {
  return bSearch(tab, 0, tab.size(), key);
}

public static int bSearch(ArrayList<Integer> tab, int begin, int end, int key) {
    int size = end - begin;
    if (size <= 0)
        return -1;

    int midPoint = (begin + end) / 2;
    int midValue = tab.get(midPoint);
    if (midValue == key)
        return midPoint;

    if (key < midValue) {
        return bSearch(tab, begin, midPoint, key);
    } else {
        return bSearch(tab, midPoint + 1, end, key);
    }
}