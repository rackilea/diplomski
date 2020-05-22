long lastLightTime = System.nanoTime();
while(ObjectSensor.Obstacle()==false
    || System.nanoTime()-lastLightTime < TimeUnit.SECONDS.toNanos(5)) {
  if (lightsensor.leftsensor() || lightsensor.rightsensor()) {  // Or other condition to reset timeout
    lastLightTime = System.nanoTime();
  }

  // The rest of your loop...
}