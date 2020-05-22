final Location myLocation = someLocation;

Collections.sort(locations, new Comparator<Location>() {
    @Override
    public int compare(Location o1, Location o2) {
        Float dist1 = o1.distanceTo(myLocation);
        Float dist2 = o2.distanceTo(myLocation);
        return dist1.compareTo(dist2);
    }
});