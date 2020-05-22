Collections.sort(myList, new Comparator<Chromosome>() {
    @Override
    public int compare(Chromosome c1, Chromosome c2) {
        return Double.compare(c1.getScore(), c2.getScore());
    }
});