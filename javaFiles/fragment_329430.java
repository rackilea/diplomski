Ship ships = new Ship();
ships.setShipName("Boom");
ships.setYearBuilt("1900");

CargoShip cargoShips = new CargoShip();
cargoShips.setShipName("Bang");
cargoShips.setCargoCapaicty(200);

CruiseShip cruiseShips = new CruiseShip();
cruiseShips.setShipName("Bam");
cruiseShips.setMaxPassengers(500);

Ship[] allShips = {ships, cargoShips, cruiseShips};