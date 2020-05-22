Comparator<Metadata> comparator = new Comparator<Metadata>() {
    @Override
    public int compare(Metadata o1, Metadata o2) {
        if (o1.sourceDate.equals(o2.sourceDate)) {
            return o1.name.compareTo(o2.name);
        } else {
            return o1.sourceDate.compareTo(o2.sourceDate);
        }
    }
};

Set<Metadata> sortedWithoutDupes = new TreeSet<Metadata> (comparator);
sortedWithoutDupes.addAll(yourList);