public static List<Integer> range(String startYear, String endYear) {
    int cur = Integer.parseInt(startYear);
    int stop = Integer.parseInt(endYear);
    List<Integer> list = new ArrayList<Integer>();
    while (cur <= stop) {
        list.add(cur++);
    }
    return list;
}