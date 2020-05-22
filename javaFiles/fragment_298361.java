@RequestMapping(value = "/user-notifications/{userId}")
@ResponseStatus(HttpStatus.OK)
@ResponseBody
public void watch(@PathVariable("userId") String userId,
                  HttpServletRequest request) throws Exception {
    //Atmosphere framework puts filter/servlet that adds ATMOSPHERE_RESOURCE to all requests
    AtmosphereResource resource = (AtmosphereResource)request.getAttribute(ApplicationConfig.ATMOSPHERE_RESOURCE);

    //suspending resource to keep connection
    resource.suspend();

    //find broadcaster, second parameter says to create broadcaster if it doesn't exist
    Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup(userId,true);

    //saving resource for notifications
    broadcaster.addAtmosphereResource(resource);
}