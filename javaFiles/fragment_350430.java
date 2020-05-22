public static List<Integer> removeAdjacentDuplicates(List<Integer> input) {
    List<Integer> result = new ArrayList<>();
    Integer last = null;
    for(int i=0; i<input.size(); i++) {
        Integer cur = input.get(i);
        if(i == 0 || !cur.equals(last))
            result.add(cur);
        last = cur;
    }
    return result;
}