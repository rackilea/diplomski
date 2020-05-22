// Define it as a constant
Logger LOGGER = Logger.getLogger(YourClient.class.getName());

// Set logging level to FINE level for request/response logging    
Feature feature = new LoggingFeature(LOGGER, Level.FINE, Verbosity.PAYLOAD_ANY,
                LoggingFeature.DEFAULT_MAX_ENTITY_SIZE);

Client client = ClientBuilder.newBuilder().register(feature).build();