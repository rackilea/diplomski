static int count(List<String> al, String name) {
    int count = 0;
    for (String s : al) {
        if (s.equals(name)) {
            count++;
        }
    }
    return count;
}