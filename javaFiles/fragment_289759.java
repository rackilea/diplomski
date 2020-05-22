int tick = 500; //set this to whatever you want
long lastTime = System.currentTimeInMillis();
while(true) {
 long currTime = System.currentTimeInMillis();
 if (currTime > lastTime + tick) {
  lastTime = currTime;
  x = x + 1; //replace this with your object's position
 }
}