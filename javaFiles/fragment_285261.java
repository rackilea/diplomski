public <T extends Vehicle> Set<T> getPremiumVehicle(Function<String, Callable<Set<T>>> vehicleSupplier, String filter) throws Exception {
    final Callable<Set<T>> retryGetCars = new RetryingCallable<T>(retryStrategy(), vehicleSupplier.apply(filter));
    return retryGetCars.call();
  }

  public <T extends Vehicle> Callable<Set<T>> getVehicle(Function<String, Set<T>> vehicleSupplier, String feature) {
    return () -> {
      Set<T> vehicles = vehicleSupplier.apply(feature);
      return Collections.unmodifiableSet(vehicles);
    };
  }