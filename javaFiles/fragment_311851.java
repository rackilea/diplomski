private Map<String, Object> properties;

public void updated(Map<String, Object> properties) {
  this.properties = properties;
  String broker   = "";
  String clientId = "";
  String topic   = "";

  if(properties != null && !properties.isEmpty()) {

    broker = (String) properties.get("broker.name");
    clientId = (String) properties.get("clientId.name");
    topic = (String) properties.get("topic.name");

    doDemo(broker, clientId, topic);
  }
}

public void doDemo(String broker, String clientId, String topic) {
  MemoryPersistence persistence = new MemoryPersistence();

  try {
    MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
    MqttConnectOptions connOpts = new MqttConnectOptions();
    connOpts.setCleanSession(true);

    sampleClient.setCallback(new MqttCallback() {
      public void connectionLost(Throwable cause) {}

      public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message: " + message.toString());
      }

      public void deliveryComplete(IMqttDeliveryToken token) {}
    });

    sampleClient.connect(connOpts);
    sampleClient.subscribe(topic);

  } catch(MqttException e) {
    e.printStackTrace();
  }
}