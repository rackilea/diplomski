mqtt = new MQTT();
try {
    if (ip == null) {
        System.out.println("Mqtt Initialized in Maps Activity");
        ip = "demo.aiotm.in:1883";
    }
    //mqtt.setHost("tcp://"+ip);
    mqtt.setHost("tcp://10.30.60.242:1883");
    connection = mqtt.blockingConnection();
    connection.connect();
} catch (Exception e) {
    e.printStackTrace();
}