Collections.sort(usables, new Comparator<Usable>() {

    @Override
    public int compare(Usable o1, Usable o2) {
        int dateComparison = o1.getDate().compareTo(o2.getDate());  //compare the dates
        if (dateComparison == 0) {  //if the dates are the same,
            return o1.getId().compareTo(o2.getId());  //sort on the id instead
        }
        return dateComparison;  //otherwise return the result of the date comparison
    }
});