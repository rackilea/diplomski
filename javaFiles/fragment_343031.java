import processing.serial.*;

Serial port;

void setup(){
  print("Serial ports: ");println(Serial.list());
  try{
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