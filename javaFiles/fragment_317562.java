// TODO: Have a reference to the Connector you are going to work with

// Remove from server first.
server.removeConnector(connector);

// Stop the connector.
// NOTE: Existing connections will still live on.  
// This will only stop accepting new connections.
connector.stop(); // might take a while (waiting for acceptors to close)

// TODO: do what you want with this connector

// Eg: harshly close existing connections
connector.getConnectedEndPoints().forEach((endpoint)-> {
    endpoint.close();
});

// Re-add stopped connector if you want
// This will start connector as well
// This can fail (eg: if port is already in use)
server.addConnector(connector);