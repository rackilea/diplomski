Arrays.sort(fClasses, new Comparator<FClass>() {
    @Override
    public int compare(FClass o1, FClass o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return o1.compareTo(o2);
    }});