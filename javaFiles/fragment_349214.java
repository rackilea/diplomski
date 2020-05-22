Collections.sort(contributorList, new Comparator<Contributor>() {
    @Override
    public int compare(Contributor o1, Contributor o2) {
       return Collator.getInstance().compare(o1.lastname, o2.lastname);
    }
});