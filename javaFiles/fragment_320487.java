Collections.sort(list, new Comparator<Zombie>() {
    @Override
    public int compare(Zombie z1, Zombie z2) {
        if (z1.x() > z2.x())
            return 1;
        if (z1.x() < z2.x())
            return -1;
        return 0;
    }
});