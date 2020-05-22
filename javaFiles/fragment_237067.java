@RequestMapping(value = "/parseHousePrice", method={RequestMethod.POST, RequestMethod.GET})
 public double parseHousePrice(@RequestBody HousePrice housePriceObject, 
                                         @RequestParam("latitude") double latitude,
                                         @RequestParam("longitude") double longitude, 
                                         Model model) {

 // This passes the lat & long into a method that will query the database
 double housePriceAverage = parseHousePrice.ParseHousePrice(latitude, longitude);

 // This print statement successfully prints the results fromt he query
 System.out.println("The average house price for this area is: " + housePriceAverage);

 return housePriceAverage;
}