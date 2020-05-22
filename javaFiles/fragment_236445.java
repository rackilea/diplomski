boolean alreadyProcessed = false;
 @Override
  public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
    if (!alreadyProcessed) {
      alreadyProcessed = true;
      for (Beacon beacon : beacons) {
        logToDisplay("The beacon " + beacon.toString() + " is about " + String.format("%.2f", beacon.getDistance()) + " meters away.");
      }
    }
  }