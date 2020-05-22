// on startup
Node node = nodeBuilder().node();
Client client = node.client();

// on shutdown
node.close();