rdd.map(lines=>ConvertToCountry(line))
   .filter(country=>country == "CANADA")

class Country{
  ...ctor that takes an array and fills properties...
  ...properties for each field from the csv...
}

ConvertToCountry(line: String){
  return new Country(line.split(','))
}