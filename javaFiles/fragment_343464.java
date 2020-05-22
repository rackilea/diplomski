public static int sumNearZero(String s) {
    List<Integer> al = new ArrayList<>();
    for (String str : s.split("\\s+")) {
        al.add(Integer.parseInt(str));
    }
    if (al.isEmpty()) {
        return 0;
    }
    Collections.sort(al);
    if (al.size() == 1) {
        return al.get(0);
    }
    return (al.get(0) + al.get(1));
}