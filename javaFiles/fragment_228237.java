@RequestMapping(value="/subscribe", method=RequestMethod.POST)
public ResponseEntity<HttpStatus> addSubscription(AtmosphereResource resource, @RequestParam("topic") String topic)
{
    String atmosphereId = resource.getResponse().getHeader(ATMOSPHERE_TRACKING_ID);
    if (atmosphereId == null || atmosphereId.isEmpty())
    {
        log.error("Cannot add subscription, as the atmosphere tracking ID was not found");
        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }
    AtmosphereResource originalResource = resourceFactory.find(atmosphereId);
    if (originalResource == null)
    {
        log.error("The provided Atmosphere tracking ID is not associated to a known resource");
        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
    }

    Broadcaster broadcaster = broadcasterFactory.lookup(topic, true);
    broadcaster.addAtmosphereResource(originalResource);
    log.info("Added subscription to {} for atmosphere resource {}",topic, atmosphereId);

    return getOkResponse();
}