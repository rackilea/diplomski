@RequestMapping("/subscribe")
public ResponseEntity<HttpStatus> connect(AtmosphereResource resource)
{
    resource.getResponse().setHeader("Access-Control-Expose-Headers", ATMOSPHERE_TRACKING_ID + "," + X_CACHE_DATE);
    resource.suspend();
}