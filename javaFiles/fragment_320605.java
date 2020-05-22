public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    for (String str : strs) {
        boolean added = false;
        for (List<String> r : result) {
            if (areAnagrams(str, r.get(0))) {
                r.add(str);
                added = true;
                break;
            }
        }

        if (!added) {
            List<String> aList = new ArrayList<>();
            aList.add(str);
            result.add(aList);
        }
    }
    return result;
}