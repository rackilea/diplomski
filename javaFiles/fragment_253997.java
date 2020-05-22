@RequestMapping(value = "/temperature", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> addTemperature(@RequestBody IncomingTemperature temperature){
    logger.info("Temperature: {} recieved", temperature);
    temperatureService.addTemperature(temperature);
    return new ResponseEntity<Void>(HttpStatus.CREATED);
}