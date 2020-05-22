@PreRemove
private void preRemove() {
   for (Car car: cars) {
      car.setManufacturer(null);
   }
}