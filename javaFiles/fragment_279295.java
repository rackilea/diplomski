class Raids implements Comparable<Raids> {
    private double distance;
    ...

    @Override
    public int compareTo(Raids instance2) {
        if (this.distance < instance2.distance)
            return -1;
        else if (this.distance > instance2.distance)
            return 1;
        else
            return 0;
    }
}