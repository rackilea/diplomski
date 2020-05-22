new Comparator() {
    @Override
    public int compare(Site s1, Site s2) {
        return (s1.getSiteNumber() - s2.getSiteNumber());
    }
}