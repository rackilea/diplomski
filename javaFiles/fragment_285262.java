public Set<Car> getPremiumCars(String filter) throws Exception {
    return getPremiumVehicle(this::getCars, filter);
  }

  public Set<Bike> getPremiumBikes(String filter) throws Exception {
    return getPremiumVehicle(this::getBikes, filter);
  }

  public Callable<Set<Car>> getCars(String feature) {
    return getVehicle(this::getCarsWithFeature, feature);
  }

  public Callable<Set<Bike>> getBikes(String feature) {
    return getVehicle(this::getBikesWithFeature, feature);
  }