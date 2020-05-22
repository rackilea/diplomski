public class Subscriber {

    private static final String CONNECTION_URL = "tcp://localhost:1883";
    private static final String SUBSCRIPTION = "iot_data";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "top-secret";


    public static void main(String[] args) throws MqttException {

       System.out.println("== START SUBSCRIBER ==");

       MqttClient client = new MqttClient(CONNECTION_URL, 
       MqttClient.generateClientId());

       MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);
       client.connect(connOpts);

       client.subscribe(SUBSCRIPTION);

    }

   private static MqttConnectOptions setUpConnectionOptions(String username, String password) {
       MqttConnectOptions connOpts = new MqttConnectOptions();
       connOpts.setCleanSession(true);
       connOpts.setUserName(username);
       connOpts.setPassword(password.toCharArray());
       return connOpts;
   }  

  }