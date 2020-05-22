boolean UniqueNums(String data) {
    Set<Character> found = new HashSet<>();
    int count = 0;
    for (char c : data.toCharArray()) {
        boolean noClash = found.add(c);

        count += (noClash ? 0 : 1);
        if (count == 2) {
            return false;
        }
    }

    return true;
}