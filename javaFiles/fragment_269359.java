int led = 13;

   void setup(){
   Serial.begin(9600);
   pinMode(led, OUTPUT);
    }
   void loop(){
   delay(100);
    }

   void serialEvent() {
   int inc = 0;
   while (Serial.available()){
   inc = Serial.parseInt();

   }
   Serial.print("Works");
   Serial.print(inc);

   }