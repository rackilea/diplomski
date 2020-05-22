private List<String[]> deepCopy(List<String[]> list) {
    List<String[]> copy = new ArrayList<String[]>(list.size());
    for (String[] element : list) {
        copy.add(Arrays.<String> copyOf(element, element.length));
    }
    return copy;
}