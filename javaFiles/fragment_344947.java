cAdapter.sort(new Comparator<Contact>() {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.toString().compareToIgnoreCase(o2.toString());
    }
});