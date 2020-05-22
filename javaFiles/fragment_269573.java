private static final Logger LOGGER = LoggerFactory.getLogger(YourClass.class);

private ShipmentService_PortType proxy;

public void init()
        throws Exception {
    ShipmentService_ServiceLocator locator = new ShipmentService_ServiceLocator();
    try {
        LOGGER.debug("Initializing shipment service...");
        proxy = locator.getShipmentServicePort(new URL("yourServiceEndpointURL"));
        ((ShipmentServicePortBindingStub) proxy).setUsername("yourUsername");
        ((ShipmentServicePortBindingStub) proxy).setPassword("yourPassword");
        ((ShipmentServicePortBindingStub) proxy).setTimeout(10000);
        LOGGER.debug("Shipment service successfully initialized.");
    } catch (ServiceException e) {
        LOGGER.error("Error in shipment client initialization", e);
        throw new Exception("Error in shipment client initialization.");
    } catch (MalformedURLException e) {
        LOGGER.error("Error in shipment client initialization", e);
        throw new Exception("Error in shipment client initialization.");
    }
}