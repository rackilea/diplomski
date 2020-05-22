public class ArduinoGUI extends JFrame implements ArduinoSerialItf { 

private ArduinoSerialItf arduinoSerialItf = null; 
private ArduinoSerial arduinoSerial = null;

 //init 
 public ArduinoGUI(){
    arduinoSerialItf = this;

   arduinoSerial = new ArduinoSerial(arduinoSerialItf );

 } 

@Override
public void onEventReceived(SerialPortEvent oEvent){
   // in GUI class you get event from ArduinoSerial 
}

}