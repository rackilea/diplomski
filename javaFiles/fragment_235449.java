@Override
    public int compareTo(@Nonnull Position2D position2D) {
        int xComparison = Integer.compare(this.getX(), position2D.getX());
        int zComparison = Integer.compare(this.getZ(), position2D.getZ());

        return xComparison != 0 ? xComparison : zComparison;
    }