beaconManager.addRangeNotifier(new RangeNotifier() {
    @Override
    public void didRangeBeaconsInRegion(Region region, Collection<Beacon> beacons) {
        for (Beacon beacon: beacons} {
          Log.d(TAG, "I see a beacon with ID1 of: "+beacon.getID1());
        }
    }
});