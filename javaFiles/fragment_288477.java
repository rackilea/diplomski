static class Element implements Comparable<Element> {
    //Constructor, field, getters
    @Override
    public int compareTo(Element o) {
        return this.sortField.compareTo(o.sortField);
    }
}