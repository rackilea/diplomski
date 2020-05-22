public class PubSub {

  MqttClient client;
  String topics[] = ["foo/#", "bar"];
  MqttCallback callback = new MqttCallback() {
    public void connectionLost(Throwable t) {
      this.connect();
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
      System.out.println("topic - " + topic + ": " + new String(message.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
    }
  };

  public static void main(String args[]) {
    PubSub foo = new PubSub();
  }

  public PubSub(){
    this.connect();
  }

  public void connect(){
    client = new MqttClient("mqtt://localhost", "pubsub-1");
    client.setCallback(callback);
    client.connect();
    client.subscribe(topics);
  }

}