Collections.sort(barList, new Comparator<Bar>() {
    @Override
    public int compare(Bar o1, Bar o2) {
        return positions.get(o1.getId()) - positions.get(o2.getId());
    }
});