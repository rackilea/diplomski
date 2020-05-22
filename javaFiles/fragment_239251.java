Set<Camp> s = new TreeSet<>(new Comparator<Camp>() {
    @Override
    public int compare(Camp o1, Camp o2) {
        return o1.getUserId().getId().equals(o2.getUserId().getId()) 
                ? o1.getCreateDt().compareTo(o2.getCreateDt()) : 0;
    }
});