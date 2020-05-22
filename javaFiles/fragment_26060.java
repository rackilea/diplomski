interface Country {
  String getName();
  int getPopulation();
  // ... etc
}

class DefaultCountry implements Country {
   // implement your methods
}

interface CountryCollection {
  addCountry(Country country);
  removeCountry(Country country);
  Country getLargestPopulation();
  Country getLargestArea();
  ....
}