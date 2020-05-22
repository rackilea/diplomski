import processing.serial.*;

Serial port;
final String PORT_TOKEN = "serial.port=";
final String BAUD_TOKEN = "serial.debug_rate=";

void setup(){
  print("Serial ports: ");println(Serial.list());
  //begin parsing arduino prefs
  String[] arduinoPrefs = loadStrings("C:\\Program Files\\Arduino\\lib\\preferences.txt");
  String portName = "";
  int baudRate = 0;
  for(String s : arduinoPrefs){//for each line in text file
    if(s.contains(PORT_TOKEN)) portName = s.substring(s.indexOf(PORT_TOKEN)+PORT_TOKEN.length());//find the PORT_TOKEN and if there is one, retrieve the value
    if(s.contains(BAUD_TOKEN)) baudRate = int(s.substring(s.indexOf(BAUD_TOKEN)+BAUD_TOKEN.length()));//do the same for the BAUD_TOKEN
  }
  //end parsing arduino prefs
  try{
    if(portName.length() > 0 && baudRate > 0) 
      port = new Serial(this,portName,baudRate);
    else
      port = new Serial(this,Serial.list()[0],9600);//try to open 1st port
  }catch(Exception e){
    System.err.println("*****Error Opening Serial Port!*****");
    e.printStackTrace();
  }
}
void draw(){/*you can draw the string to screen here if you like*/}
void serialEvent(Serial p) { 
  println(p.readString()); 
}