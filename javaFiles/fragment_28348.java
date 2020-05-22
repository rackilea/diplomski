enum Car {
  ASTON_MARTIN_DB9(3, "Aston Martin DB9", ImagesHolder.Aston_Martin_DB9Icon),
  ACURA_NSX(7, "Acura NSX", ImagesHolder.Acura_NSXIcon),
  // etc, for other cars.
  ;

  private final int number;
  private final String name;
  private final ImageIcon icon;

  private Car(int number, String name, ImageIcon icon) {
    // Assign parameters to fields.
  }

  // Add getters.
}