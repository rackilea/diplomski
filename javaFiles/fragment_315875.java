@RequestMapping(value = "/getVehicle/{id}", method = RequestMethod.GET)
public Vehicle getVehicle(@PathVariable("id") int id) throws IOException {

    //ObjectMapper provides functionality for reading and writing JSON
    ObjectMapper mapper = new ObjectMapper();

    //Makes inventory.txt an iterable object
    LineIterator inventory = FileUtils.lineIterator(new File("./inventory.txt"),
            CharEncoding.UTF_8);

    //Container for when vehicle is found
    String vehicle = "";

    //iterates through inventory.txt until it reaches the end or finds the vehicle via id
    while(inventory.hasNext()) { 
        //Stores each vehicle
        String tempVehicle = inventory.next(); 
        //Creates a vehicle object for JSON
        Vehicle v = mapper.readValue(tempVehicle, Vehicle.class); 

        //checks if id of JSON vehicle object matches the id passed through
        if(v.getId() == id) { 
            vehicle = tempVehicle;
        }
    }
    //Returns the found vehicle as a new Objectmapper (still a bit confused about this one)
    return new ObjectMapper().readValue(vehicle, Vehicle.class);
}