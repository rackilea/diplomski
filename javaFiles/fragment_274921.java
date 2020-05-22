Collections.sort(freshCopyOfList, new Comparator<RetrievedPage>() {
    public int compare(RetrievedPage o1, RetrievedPage o2) {
        int firstPagePosition = previousCopyOfList.indexOf(o1);
        int secondPagePosition = previousCopyOfList.indexOf(o2);

        if (secondPagePosition == -1) return -1;
        if (firstPagePosition == -1) return 1;

        return firstPagePosition - secondPagePosition;
    }
});