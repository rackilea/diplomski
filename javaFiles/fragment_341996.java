public static List<Integer> getIndexOfLargest(List<Integer> list) {
    List<Integer> indicesOfLargest = new ArrayList();
    if (list == null || list.size() == 0)
        return indicesOfLargest; // null or empty
    Integer i = 0, max = null;
    for (Integer x : list) {
        if (x != null) {
            if (max == null || x > max) {
                indicesOfLargest.clear();
                max = x;
                indicesOfLargest.add(i);
            } else if (x == max) {
                indicesOfLargest.add(i);
            }
            i++;
        }
    }
    return indicesOfLargest;
}