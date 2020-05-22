public class MQTT_Client implements MqttCallback {

 private MqttClient mqtt;

 public boolean connect(){
    try{
       mqtt = new MqttClient(....);
       ....
       mqtt.connect();
       //Connected
       return true;
    catch(MqttException e){
       //Connection failed
       return false;
    }
 }

 @Override
public void connectionLost(Throwable cause) {
    //Connection Lost
}