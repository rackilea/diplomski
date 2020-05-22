cAdapter.sort(new Comparator<Contact>() {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getLName().compareToIgnoreCase(c2.getLName());
    }
});