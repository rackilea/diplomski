class ListComparator implements Comparator<List<String>> {
    @Override
    public int compare(List<String> o1, List<String> o2) {
        return o1.get(1).compareTo(o2.get(1));
    }
}

mainList.sort(new ListComparator());