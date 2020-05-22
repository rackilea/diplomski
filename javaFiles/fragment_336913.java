private static Logger logger;
@Override
public void init(ServletConfig servletConfig) throws ServletException {
    super.init(servletConfig);
    logger = Logger.getLogger(AtmosphereHandler.class);
}

@Override
public int doComet(GwtAtmosphereResource resource) throws ServletException, IOException {
    logger.info("Connecting to comet with: " +resource.getRequest().getRequestURI());
    Broadcaster broadcaster = BroadcasterFactory.getDefault().lookup(YOUR_CONNECTION_ID, true);
    if(broadcaster.getAtmosphereResources().size()>0){
        logger.debug("Broadcaster recovered with name: " + broadcaster.getID());
    }
    else{
        logger.debug("Broadcaster created with name: " + broadcaster.getID());
    }
    resource.getAtmosphereResource().setBroadcaster(broadcaster);
    return NO_TIMEOUT;
}

@Override
public void cometTerminated(GwtAtmosphereResource cometResponse, boolean serverInitiated) {
    logger.info("Disconnecting from comet. Broadcaster : " + cometResponse.getBroadcaster().getID());
    super.cometTerminated(cometResponse, serverInitiated);
}

@Override
public void doPost(HttpServletRequest postRequest, HttpServletResponse postResponse,
        List<?> messages, GwtAtmosphereResource cometResource) {
    broadcast(messages, cometResource);
}