AutoBeanClientSerializer json_serializer = new AutoBeanClientSerializer();
    json_serializer.registerBeanFactory(beanFactory, ActivityMessage.class);
    AtmosphereRequestConfig jsonRequestConfig = AtmosphereRequestConfig.create(json_serializer);
    jsonRequestConfig.setUrl(GWT.getHostPageBaseURL() + HANDLER_URL_PART);
    jsonRequestConfig.setContentType("application/json; charset=UTF-8");
    jsonRequestConfig.setTransport(AtmosphereRequestConfig.Transport.WEBSOCKET);
    jsonRequestConfig.setFallbackTransport(AtmosphereRequestConfig.Transport.STREAMING);
    jsonRequestConfig.setOpenHandler(new AtmosphereOpenHandler() {
        @Override
        public void onOpen(AtmosphereResponse response) {
            GWT.log("JSON Connection opened");
        }
    });
    jsonRequestConfig.setCloseHandler(new AtmosphereCloseHandler() {
        @Override
        public void onClose(AtmosphereResponse response) {
            GWT.log("JSON Connection closed");
        }
    });
    jsonRequestConfig.setMessageHandler(new AtmosphereMessageHandler() {
        @Override
        public void onMessage(AtmosphereResponse response) {

        }
    });


    Atmosphere atmosphere = Atmosphere.create();
    final AtmosphereRequest jsonRequest = atmosphere.subscribe(jsonRequestConfig);