// Get the car's location.
Point loc = car.getLocation();

// Create a string representation: [x,y]
String locString = "[" + loc.x + "," + loc.y + "]";

// Add the line with all the other stuff
fileWriter.println(car.getId() + " " + car.getStart() + " " + locString + " "
  + car.getNumSpotsTried());