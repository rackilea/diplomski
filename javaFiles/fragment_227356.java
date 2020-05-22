public static List<String> range(String startYear, String endYear) {
    int cur = Integer.parseInt(startYear);
    int stop = Integer.parseInt(endYear);
    List<String> list = new ArrayList<String>();
    while (cur <= stop) {
        list.add(String.valueOf(cur++));
    }
    return list;
}