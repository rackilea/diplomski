Collections.sort(myList, new Comparator<ListItem>() {
    @Override
    public int compare(ListItem lhs, ListItem rhs) {
        if (lhs.getLabel() == null) {
            if (rhs.getLabel() == null) {
                return 0;
            }
            return 1;
        }
        if (rhs.getLabel() == null) {
            return -1;
        }
        return lhs.getLabel().compareTo(rhs.getLabel());
    }
});