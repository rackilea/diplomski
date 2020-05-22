private List<String[]> deepCopy(List<String[]> list) {
    List<String[]> copy = new ArrayList<String[]>(list.size());
    for (String[] element : list) {
        String[] elementCopy = new String[element.length];
        System.arraycopy(element, 0, elementCopy, 0, element.length);
        copy.add(elementCopy);
    }
    return copy;
}