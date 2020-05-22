public class ArduinoSerial implements SerialPortEventListener {

private ArduinoSerialItf arduinoSerialItf = null;

public ArduinoSerial(ArduinoSerialItf arduinoSerialItf){
  this.arduinoSerialItf = arduinoSerialItf;
} 

@Override
public synchronized void serialEvent(SerialPortEvent oEvent) {
    // when we call this method, event goes to GUI class
    arduinoSerialItf.onEventReceived(oEvent);

}