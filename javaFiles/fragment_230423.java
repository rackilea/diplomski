private void start(final WebSocketSession session, JsonObject jsonMessage)
{
    // ---- Media pipeline
    log.info("[Handler::start] Adding a new client!");

    final UserSession user = new UserSession();
    users.put(session.getId(), user);

    if(pipeline==null){
        log.info("[Handler::start] Create Media Pipeline");
        pipeline = kurento.createMediaPipeline();
        dispatcher = new DispatcherOneToMany.Builder(pipeline).build();
    }

    final WebRtcEndpoint webRtcEp = new WebRtcEndpoint.Builder(pipeline).build();
    user.setWebRtcEndpoint(webRtcEp);

    HubPort hubPort = new HubPort.Builder(dispatcher).build();
    user.setHubPort(hubPort);
    hubPort.connect(webRtcEp);
    webRtcEp.connect(hubPort);

    if(users.size()==1) {
        log.info("[Handler::start] It's first user, then set it as source");
        dispatcher.setSource(hubPort);
    }
[...]