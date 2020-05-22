class Player implements Comparable<Player> {
    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.getCapital(), other.getCapital());
    }

    ...
}