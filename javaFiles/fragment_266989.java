@Transactional
public void process() {
  client.getAssignments()
      .stream()
      .forEach(a -> {
        log.debug("[d] Assignment: {}", a);

        Driver driver = new Driver();

        driver.setId(a.getDriverId());
        driver.setFirstName(a.getFirstName());
        driver.setLastName(a.getLastName());
        driver.setMiddleName(a.getMiddleName());

        driver.setLocation(
            locationRepo.findById(new Location.PK(a.getLocationId(), a.getLocationName()))
                .orElse(new Location(a.getLocationId(), a.getLocationName()))
        );

        driver.setCarrier(
            carrierRepo.findById(a.getCarrierId().trim())
                .orElse(new Carrier(a.getCarrierId().trim()))
        );

        driverRepo.saveAndFlush(driver);

        log.debug("[d] Driver: {}", driver);
      });
}