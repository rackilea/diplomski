Collections.sort(myList, new Comparator<One>() {
    @Override
    public int compare(One o1, One o2) {
        return o1.getID().compareTo(o2.getID());
    }
});