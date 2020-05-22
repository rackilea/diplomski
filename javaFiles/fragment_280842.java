public static <T> List<String> mergeLists(List<List<T>> lists){
    Collections.sort(lists, (x, y) -> y.size() - x.size());
    List<String> result = lists.remove(0).stream().map(e -> e.toString()).collect(Collectors.toList());
    int longestListSize = result.size();
    for (int i = 0; i < longestListSize; i++) {
        StringBuilder row = new StringBuilder(result.get(i).toString());
        for(List<T> list : lists) {
            if(i < list.size()) {
                row.append(list.get(i));
            }
        }
        result.set(i, row.toString());
    }

    return result;
}