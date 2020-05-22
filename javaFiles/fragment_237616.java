final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
URI uri = new URI(
    "wss://threatmap.checkpoint.com/ThreatPortal/websocket" +
    "?X-Atmosphere-tracking-id=0" +
    "&X-Atmosphere-Framework=2.2.5-javascript" +
    "&X-Atmosphere-Transport=websocket" +
    "&X-Atmosphere-TrackMessageSize=true" +
    "&Content-Type=application/json" +
    "&X-atmo-protocol=true"
);
ClientManager client = ClientManager.createClient();
try (Session session = client.connectToServer(new Endpoint() {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String message) {
                // The data is of type "number|JSON Object"
                // so we remove everything before the JSON Object
                message = message.substring(message.indexOf('|') + 1);
                if (!message.startsWith("{")) {
                    // Not a JSON Object so we skip it
                    return;
                }
                // Parse the JSON Object
                JSONObject jsonObject = new JSONObject(message);
                if (jsonObject.has("attackname")) {
                    System.out.printf(
                        "Time: %tT Attack: %-40s Attacking Country: %-20s Target Country: %-20s%n",
                        Calendar.getInstance(), jsonObject.getString("attackname"),
                        new Locale("", jsonObject.getString("sourcecountry")).getDisplayName(),
                        new Locale("", jsonObject.getString("destinationcountry")).getDisplayName()
                    );
                }
            }
        });
    }
}, cec, uri)) {
    CountDownLatch messageLatch = new CountDownLatch(1);
    // Wait forever
    messageLatch.await();
}